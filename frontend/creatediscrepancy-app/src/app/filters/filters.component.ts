import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { EstacionesService , TollDTO , CarrilesService , LaneDTO , TurnosService , ShiftDTO , PagosService, PaymentFormDTO, Direction, CategoryDTO, CategorasService, RateType } from '@tsir/tolls-api';
import { DatePipe } from '@angular/common';
import Swal from 'sweetalert2';
import { DiscrepanciaService, ReconcileDTO } from '@tsir/creatediscrepancy-api';

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css']
})
export class FiltersComponent implements OnInit {

  @Output()
  mapOut = new EventEmitter<any>() ;

  @Output()
  directionsOut = new EventEmitter<{}>() ;

  map : any = {};

  filterForm: FormGroup;

  tolls: TollDTO[];

  lanes: LaneDTO[];

  shifts: ShiftDTO[];

  paymentsForm:PaymentFormDTO[];

  date = new Date();

  directions: {};

  discrepancyDTOS: ReconcileDTO[];
  discrepancyLista: ReconcileDTO={};
  discrepancyListaDTO: ReconcileDTO={};
  categorias: CategoryDTO[] = [];
  axles: CategoryDTO[] = [];
  constructor(
    private formBuilder: FormBuilder,
    private estacionesService: EstacionesService,
    private carrilesService: CarrilesService,
    private turnosService: TurnosService,
    private pagosService:PagosService,
    public datepipe: DatePipe,
    private conciliacinService: DiscrepanciaService,
    private categoriasService: CategorasService,
  ) {
  }



  ngOnInit() {
    this.estacionesService.configuration.accessToken = localStorage.getItem("token");
    this.carrilesService.configuration.accessToken = localStorage.getItem("token");
    this.turnosService.configuration.accessToken = localStorage.getItem("token");
    this.pagosService.configuration.accessToken = localStorage.getItem("token");
    this.conciliacinService.configuration.accessToken = localStorage.getItem("token");
    this.categoriasService.configuration.accessToken = localStorage.getItem("token");
    this.initLoginForm();
  }

  private initLoginForm() {
    this.filterForm = this.formBuilder.group({
      DATECOLLECTION: ["", Validators.required],
      STATIONAME: [null, Validators.required],
      LANECODE: [null],
      TURNCODE: [null],
      CATEGORIA: [null],
      NUMEROTIKETE: [null],
      //PAYMENTID: [null],
    });
    this.estacionesService.findTolls(null).subscribe(
      result  => {
        this.tolls = result;
      }
    );


  }


  public loadParams() {

    let filtesr = this.filterForm.value;
    let latest_date =this.datepipe.transform(filtesr.DATECOLLECTION, 'yyyy-MM-dd');


    if ( filtesr.DATECOLLECTION ) {
      this.map['DATECOLLECTION'] = latest_date;
    }
    if ( filtesr.LANECODE ) {
      this.map['LANEID'] = filtesr.LANECODE;
    }
    if ( filtesr.TURNCODE ) {
      this.map['TURNCODE'] = filtesr.TURNCODE;
    }
    if ( filtesr.CATEGORIA ) {
      this.map['CATEGORYID'] = filtesr.CATEGORIA;
    }

    if ( filtesr.NUMEROTIKETE ) {
      this.map['TIKETENUM'] = filtesr.NUMEROTIKETE;
    }
    if (filtesr.LANECODE != null ) {
      this.map['STATUSCONC'] = "N";
    }
    this.mapOut.emit(this.map);
  }

  private findAxles(): void {
    let filterAxles = {};
    filterAxles["TOLL"] = this.filterForm.controls["STATIONAME"].value;
    filterAxles["RATE"] = RateType.PLENA;
    filterAxles["AXLE"] = true;
    filterAxles["DATE"] = "2021-08-08";
    this.categoriasService.findCategories(filterAxles).subscribe((result) => {
      this.axles = result;
      this.axles = this.axles.filter((c) => c.axleCode);
    });
  }

  public LoadParametersStation() {
    this.map = {};
    let MapTollCat = {};
    MapTollCat["TOLL"] = this.filterForm.controls["STATIONAME"].value;
    MapTollCat["RATE"] = "PLENA";
    MapTollCat["AXLE"] = false;
    MapTollCat["DATE"] = "2021-08-08";
    this.categoriasService
      .findCategories(MapTollCat)
      .subscribe((result) => (this.categorias = result));
    this.findAxles();
    this.findLanes();
    this.findShifts();
    this.loadDirections(this.filterForm.controls['STATIONAME'].value)

  }

  private loadDirections(tollId: number) {
    let toll: TollDTO= this.tolls.filter(toll=>  toll.code == tollId )[0];
    console.log ("toll = "+ JSON.stringify(toll) );
    if (toll != null) {
      this.directions = [
        {
          key: Direction.PRINCIPAL,
          label: toll.mainName ? toll.mainName : Direction.PRINCIPAL,
        },
        {
          key: Direction.RETORNO,
          label: toll.returnName ? toll.returnName : Direction.RETORNO,
        },
      ];
    } else {
      this.directions = [];
    }
    this.directionsOut.emit(this.directions);
  }

  public findLanes() {
    if ( this.filterForm.controls['STATIONAME'].value !== null ) {
      let map = {};
      map['TOLL'] = this.filterForm.controls['STATIONAME'].value;
      this.carrilesService.findLanes(map).subscribe(
        result => {
          this.lanes = result;
        }
      );
    }else {
      this.lanes = [];
    }
    this.filterForm.controls['LANECODE'].setValue(null);
  }

  public findShifts() {
    if (this.filterForm.controls['STATIONAME'].value !== null) {
      let map = {};
      map['TOLL'] = this.filterForm.controls['STATIONAME'].value;
      this.turnosService.findShifts(map).subscribe(
        result => {
          this.shifts = result;
        }
      );
    }else {
      this.shifts = [];
    }
    this.filterForm.controls['TURNCODE'].setValue(null);
  }

  public clear(){
    this.initLoginForm();
    this.map['STATUSCONC'] = 'N';
    this.map['DATECOLLECTION'] = null;
    this.filterForm.controls['DATECOLLECTION'].setValue(null);
  }

}
