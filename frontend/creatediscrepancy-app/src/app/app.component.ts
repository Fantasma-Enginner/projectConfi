import { Component, OnInit } from "@angular/core";
//import { DiscrepanciaService, DiscrepancyDTO } from '@tsir/discrepancy-api';
import { ReconcileDTO, DiscrepanciaService } from "@tsir/creatediscrepancy-api";

import { UsuariosService } from "@tsir/users-api";
import {
  PagosService,
  EstacionesService,
  CarrilesService,
  CategorasService,
  CategoryDTO,
  RateType,
} from "@tsir/tolls-api";
import { ImagenesService, ImagesDTO } from "@tsir/evidence-api";
import {
  NgbModal,
  ModalDismissReasons,
  NgbModalRef,
} from "@ng-bootstrap/ng-bootstrap";
import { ParameterService } from "@tsir/parameters-api";
import Swal from "sweetalert2";
import { ComponentVP, ModuleType, ModuleVP } from "@tsir/commons";
import { environment } from "src/environments/environment";
import { map } from "rxjs/operators";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent implements OnInit {
  titulo = "Crear discrepancia";
  //pagination
  pageSize = 7;
  desde: number = 0;
  hasta: number = 7;

  //pagination
  page = 1;
  count = 0;
  pageSizeDefault = 10;
  pageSizes = [5, 10, 15];
  allPages = 0;

  public moduleVP: ModuleVP;
  discrepancyDTOS: ReconcileDTO[];
  reconcile: ReconcileDTO = {};

  toll: string;
  user: string;

  lane: number;
  images: ImagesDTO[] = [];
  imagesPlate: ImagesDTO[] = [];
  closeResult: string;
  categorias: CategoryDTO[] = [];
  axles: CategoryDTO[] = [];
  newCate: boolean = false;
  ejes: boolean = false;
  shadow_toll: boolean = false;
  inputPlaca: boolean = false;
  cateSel: number;
  axleSelected: number;
  numEjes: number;
  plac: string = null;
  modalRef: any;
  nameFormaPago = "";
  updateConsult: boolean = false;
  mapInput: any = {};
  min: number;
  max: number;
  directions: {};
  public load = false;
  validarCategoria: Boolean = false;
  constructor(
    private conciliacinService: DiscrepanciaService,
    private usersService: UsuariosService,
    private estacionesService: EstacionesService,
    private pagosService: PagosService,
    private carrilService: CarrilesService,
    private imagesServices: ImagenesService,
    private categoriaService: CategorasService,
    private modalService: NgbModal
  ) {
    this.initializeModuleVP();
  }
  ngOnInit(): void {
    // this.discrepancyDTOS.push(dacTic);
    this.conciliacinService.configuration.accessToken =  localStorage.getItem("token");
    this.usersService.configuration.accessToken =  localStorage.getItem("token");
    this.estacionesService.configuration.accessToken =  localStorage.getItem("token");
    this.carrilService.configuration.accessToken =  localStorage.getItem("token");
    this.imagesServices.configuration.accessToken =  localStorage.getItem("token");
    this.categoriaService.configuration.accessToken =  localStorage.getItem("token");



  }
  handlePageChange(event: any) {
    this.page = event;
    this.consultReconcile(this.mapInput);
  }
  handlePageSizeChange(event: any) {
    this.pageSize = event.target.value;
    this.page = 1;
    this.consultReconcile(this.mapInput);
  }
  //mostrar o ocultar el zoom
  mostrar: boolean = false;
  mostrarZoom: String = "Mostar Zoom";

  mostrarOcultarZoom() {
    this.mostrar = !this.mostrar;
    if (this.mostrar) {
      this.mostrarZoom = "Ocultar Zoom";
    } else {
      this.mostrarZoom = "Mostar Zoom";
    }
  }
  mostrar1: boolean = false;
  mostrarZoom1: String = "Mostar Zoom";
  mostrarOcultarZoom1() {
    this.mostrar1 = !this.mostrar1;
    if (this.mostrar1) {
      this.mostrarZoom1 = "Ocultar Zoom";
    } else {
      this.mostrarZoom1 = "Mostar Zoom";
    }
  }

  imageZoom(imgID, resultID) {
    var img, lens, result, cx, cy;
    img = document.getElementById(imgID);
    result = document.getElementById(resultID);
    /*create lens:*/
    lens = document.createElement("DIV");
    lens.setAttribute("class", "img-zoom-lens");
    /*insert lens:*/
    img.parentElement.insertBefore(lens, img);
    /*calculate the ratio between result DIV and lens:*/
    cx = result.offsetWidth / lens.offsetWidth;
    cy = result.offsetHeight / lens.offsetHeight;
    /*set background properties for the result DIV:*/
    result.style.backgroundImage = "url('" + img.src + "')";
    result.style.backgroundSize =
      img.width * cx + "px " + img.height * cy + "px";
    /*execute a function when someone moves the cursor over the image, or the lens:*/
    lens.addEventListener("mousemove", moveLens);
    img.addEventListener("mousemove", moveLens);
    /*and also for touch screens:*/
    lens.addEventListener("touchmove", moveLens);
    img.addEventListener("touchmove", moveLens);
    function moveLens(e) {
      var pos, x, y;
      /*prevent any other actions that may occur when moving over the image:*/
      e.preventDefault();
      /*get the cursor's x and y positions:*/
      pos = getCursorPos(e);
      /*calculate the position of the lens:*/
      x = pos.x - lens.offsetWidth / 2;
      y = pos.y - lens.offsetHeight / 2;
      /*prevent the lens from being positioned outside the image:*/
      if (x > img.width - lens.offsetWidth) {
        x = img.width - lens.offsetWidth;
      }
      if (x < 0) {
        x = 0;
      }
      if (y > img.height - lens.offsetHeight) {
        y = img.height - lens.offsetHeight;
      }
      if (y < 0) {
        y = 0;
      }
      /*set the position of the lens:*/
      lens.style.left = x + "px";
      lens.style.top = y + "px";
      /*display what the lens "sees":*/
      result.style.backgroundPosition = "-" + x * cx + "px -" + y * cy + "px";
    }
    function getCursorPos(e) {
      var a,
        x = 0,
        y = 0;
      e = e || window.event;
      /*get the x and y positions of the image:*/
      a = img.getBoundingClientRect();
      /*calculate the cursor's x and y coordinates, relative to the image:*/
      x = e.pageX - a.left;
      y = e.pageY - a.top;
      /*consider any page scrolling:*/
      x = x - window.pageXOffset;
      y = y - window.pageYOffset;
      return { x: x, y: y };
    }
  }
  private initializeModuleVP(): void {
    let components: ComponentVP[] = [
      {
        type: ModuleType.CLIENT,
        name: environment.NAME,
        version: environment.VERSION,
        state: 1,
      },
      { type: ModuleType.SERVICE, name: "discrepancy-create" },
    ];
    this.moduleVP = {
      name: "discrepancy",
      components: components,
    };
  }


  public addItem(map: any) {
    this.updateConsult = false;
    this.mapInput = map;
    this.consultReconcile(this.mapInput);
  }

  public addDirection(directions) {
    this.directions = directions;
    console.log( "directiones: " + this.directions[0].label + " " +  this.directions[1].label
    );
  }

  public consultReconcile(map: any) {
    let carril;
    let mapLanes = {};
    mapLanes["LABEL"] = map.LANEID;
    this.carrilService.findLanes(mapLanes).subscribe((result) => {
      carril = result[0].code;
    });
    this.load = true;
    let paging = { INDEX: this.page, SIZE: this.pageSize };
    this.conciliacinService
      .findStepsWithoutDiscrepancy(map, paging, undefined)
      .subscribe(
        (result) => {
          result.forEach((discrepancy) => {
            discrepancy.laneId = carril;
          });
          this.discrepancyDTOS = result;
          if (!this.updateConsult && result.length == 0) {
            Swal.fire(
              "Sin resultados",
              `No existen discrepancias con la búsqueda realizada.`,
              "question"
            );
            this.load = false;
          } else {
            // Swal.fire('Consulta realizada', `Búsqueda realizada con exito.`, 'success');
            this.load = false;
          }
        },
        (error) => {
          if (!this.updateConsult && error.error.code == "403") {
            Swal.fire(
              "No tiene permisos",
              `No posee permisos para esta accion`,
              "error"
            );
          } else {
            Swal.fire(
              "Hubo un error",
              `Hubo un error, por favor comuniquese con el administrador`,
              "error"
            );
            this.load = false;
          }
        }
      );
  }

  public clear() {}

  Upper(event: any) {
    if (this.plac !== null) {
      this.plac = this.plac.toUpperCase();
    }
  }

  //update categoria consola
  seleccategory(idCategori) {
    this.reconcile.consoleCategory = idCategori;
    this.reconcile.dateCollection = this.reconcile.dateCollection;
  }
  updateCategori() {
    console.log("estea en mi data:" + JSON.stringify(this.reconcile.idConc));
    //valida que la consosa y el dac sena iguales 4 = 4 ejemplo
    this.load = true;
    if (this.reconcile.consoleCategory == this.reconcile.dacCategory) {
      Swal.fire('Categoría consola no ha sido modificada.', '', 'info');
      this.consultReconcile(this.mapInput);
    } else {
      Swal.fire({
        title: "¿Está seguro de crear la discrepancia?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        cancelButtonText: "Cancelar",
        confirmButtonText: "Aceptar",
      }).then((result) => {
        if (result.isConfirmed) {
          if (this.reconcile.consoleCategory != this.reconcile.dacCategory) {
            this.load=true;
            this.conciliacinService.createDiscrepancy(this.reconcile, this.reconcile.idConc).subscribe((result) => {
                let carril;
                let mapLanes = {};
                mapLanes["LANEID"] = this.reconcile.laneId;
                mapLanes["CATEGORYID"] = this.reconcile.consoleCategory;
                mapLanes["STATUSCONC"] = "N";
                this.carrilService.findLanes(mapLanes).subscribe((result) => {
                  carril = result[0].code;
                });
                this.load = true;
                let paging = { INDEX: this.page, SIZE: this.pageSize };
                this.conciliacinService
                  .findStepsWithoutDiscrepancy(mapLanes, paging, undefined)
                  .subscribe(
                    (result) => {
                      result.forEach((discrepancy) => {
                        discrepancy.laneId = carril;
                      });
                      this.discrepancyDTOS = result;
                      if (!this.updateConsult && result.length == 0) {
                        Swal.fire('Discrepancia registrada correctamente', '', 'success');
                        this.load = false;
                      } else {
                        // Swal.fire('Consulta realizada', `Búsqueda realizada con exito.`, 'success');
                        this.load = false;
                      }
                    },
                    (error) => {
                      if (!this.updateConsult && error.error.code == "403") {
                        Swal.fire(
                          "No tiene permisos",
                          `No posee permisos para esta accion`,
                          "error"
                        );
                      } else {
                        Swal.fire(
                          "Hubo un error",
                          `Hubo un error, por favor comuniquese con el administrador`,
                          "error"
                        );
                        this.load = false;
                      }
                    }
                  );
              //this.consultReconcile(this.mapInput);
              this.load= false;
            },
            (error) => {
              if ((error.error.status = 400)) {
                Swal.fire(
                  "Fecha de recaudo cerrada.",
                  error.error.errorDia,
                  "warning"
                );

                this.consultReconcile(this.mapInput);
                this.load= false;
              }

              if (error.error.code == "403") {
                Swal.fire(
                  "No tiene permisos",
                  "No posee permisos para esta acción",
                  "error"
                );
                this.load= false;
              }
              console.log(error);
            }
          );
          }


        }else{
          this.consultReconcile(this.mapInput);
        }
      });
    }
  }
  open(content, discrepancy) {
    this.reconcile = discrepancy;
    let mapToll = {};
    mapToll["CODE"] = this.reconcile.stationCode;

    let MapTollCat = {};
    MapTollCat["TOLL"] = this.reconcile.stationCode;
    MapTollCat["RATE"] = "PLENA";
    MapTollCat["AXLE"] = false;
    MapTollCat["DATE"] = "2021-08-08";
    this.categoriaService
      .findCategories(MapTollCat)
      .subscribe((result) => (this.categorias = result));
    this.findAxles();
    this.estacionesService.findTolls(mapToll).subscribe((result) => {
      this.toll = result[0].name;
      console.log("esta es mi estacion por id a nombre:" + this.toll);
    });
    let mapUser = {};
    mapUser["CODE"] = this.reconcile.usercode;
    this.usersService.findUsers(mapUser).subscribe((result) => {
      if (result.length > 0) {
        this.user = result[0].firstName + " " + result[0].lastName;
      }
    });

    let map = {};
    map["STATIONCODE"] = "0" + this.reconcile.stationCode.toString();
    map["LANECODE"] = "0" + this.reconcile.laneId.toString();
    let date: string[] = this.reconcile.dateTransaction
      .split(" ")[0]
      .split("-");
    map["TRANSACTIONDATE"] = date[0] + "" + date[1] + "" + date[2];
    let time: string[] = this.reconcile.dateTransaction
      .split(" ")[1]
      .split(":");

    map["TRANSACTIONHOUR"] =
      time[0] + "" + time[1] + "" + time[2].split(".")[0];
    map["IMAGESTYPE"] = "tran/";
    this.imagesServices
      .getImages(map)
      .subscribe((result) => (this.images = result));

    map["IMAGESTYPE"] = "plate/";
    this.imagesServices
      .getImages(map)
      .subscribe((result) => (this.imagesPlate = result));

    this.modalRef = this.modalService.open(content, {
      ariaLabelledBy: "modal-basic-title",
      size: "xl",
    });
    this.modalRef.result.then(
      (result) => {
        this.closeResult = `Closed with: ${result}`;
      },
      (reason) => {
        this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
      }
    );

    this.findFormaPago(this.reconcile.idFormPago);
  }

  private findAxles(): void {
    let filterAxles = {};
    filterAxles["TOLL"] = this.reconcile.stationCode;
    filterAxles["RATE"] = RateType.PLENA;
    filterAxles["AXLE"] = true;
    filterAxles["DATE"] = "2021-08-08";
    this.categoriaService.findCategories(filterAxles).subscribe((result) => {
      this.axles = result;
      this.axles = this.axles.filter((c) => c.axleCode);
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return "by pressing ESC";
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return "by clicking on a backdrop";
    } else {
      return `with: ${reason}`;
    }
  }

  public findFormaPago(id: number) {
    let map = {};
    map["CODE"] = id;
    if (id !== undefined && id != null) {
      this.pagosService.findPaymentsForms(map).subscribe(
        (result) => {
          this.nameFormaPago = result[0].name;
          console.log(this.nameFormaPago);
        },
        (error) => {
          this.nameFormaPago = "--";
        }
      );
    }
  }
}
