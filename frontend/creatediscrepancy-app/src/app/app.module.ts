import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {APP_BASE_HREF, DatePipe, PlatformLocation} from '@angular/common';
import {environment} from '../environments/environment';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { FiltersComponent } from './filters/filters.component';
import { BASE_PATH as PATH_TOLL, CarrilesService, CategorasService, EstacionesService, TurnosService} from '@tsir/tolls-api';
import { BASE_PATH as PATH_DISCREPANCY} from '@tsir/discrepancy-api';
import { BASE_PATH as PATH_USERS, UsuariosService} from '@tsir/users-api';
import { BASE_PATH as PATH_CONCILIATION, DiscrepanciaService} from '@tsir/creatediscrepancy-api';

import { BASE_PATH as PATH_EVIDENCE, ImagenesService} from '@tsir/evidence-api';
import { BASE_PATH as PATH_PARAMETER, ParameterService} from '@tsir/parameters-api'
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { ThomasModule } from '@tsir/commons';
import { BASE_PATH as ACTUATOR_PATH } from '@tsir/actuator-api';
import { PaginationComponent } from './pagination/pagination.component';

const routes: Routes = [
  {path: 'creatediscrepancy-app', component: AppComponent , pathMatch: 'full'},
];

@NgModule({
  declarations: [
    AppComponent,
    FiltersComponent,
    PaginationComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule,
    FormsModule,
    NgbModule,
    ThomasModule
  ],
  providers: [
    DatePipe,
    EstacionesService,
    UsuariosService,
    CarrilesService,
    TurnosService,
    CategorasService,
    ParameterService,
    ImagenesService,
    DiscrepanciaService,
    {provide: APP_BASE_HREF, useValue: '/' },
    {provide: PATH_CONCILIATION, useFactory: (pl: PlatformLocation) => GetUrlConciliation(pl), deps: [PlatformLocation]},


    {provide: PATH_TOLL, useFactory: (pl: PlatformLocation) => GetUrlToll(pl), deps: [PlatformLocation]},
    {provide: PATH_USERS, useFactory: (pl: PlatformLocation) => getUsersURL(pl), deps: [PlatformLocation]},
    {provide: PATH_EVIDENCE, useFactory: (pl: PlatformLocation) => GetUrlEvicence(pl), deps: [PlatformLocation]},
    {provide: PATH_PARAMETER, useFactory: (pl: PlatformLocation) => GetUrlParameter(pl), deps: [PlatformLocation]},
    {provide: ACTUATOR_PATH, useFactory: getBaseURL, deps: [PlatformLocation]},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }


const portGateway = 8760;

export function getBaseURL(pl: PlatformLocation) {
  const protocol = environment.production ? pl.protocol : 'http:';
  return `${protocol}//${pl.hostname}:${portGateway}`;
}


export function GetUrlConciliation(pl: PlatformLocation) {
  let protocol = environment.production ? pl.protocol : 'http:';
  return `${protocol}//${pl.hostname}:${portGateway}/discrepancy-create/api/v1`;
}


export function GetUrlToll(pl: PlatformLocation) {
  let protocol = environment.production ? pl.protocol : 'http:';
  return `${protocol}//${pl.hostname}:${portGateway}/tolls-manager/api/v1`;
}

export function getUsersURL(pl: PlatformLocation) {
  const protocol = environment.production ? pl.protocol : 'http:';
  return `${protocol}//${pl.hostname}:${portGateway}/settings-users/api/v1`;
}


export function GetUrlEvicence(pl: PlatformLocation) {
  let protocol = environment.production ? pl.protocol : 'http:';
  return `${protocol}//${pl.hostname}:${portGateway}/evidence-pass/api/v1`;
}

export function GetUrlParameter(pl: PlatformLocation) {
  let protocol = environment.production ? pl.protocol : 'http:';
  return `${protocol}//${pl.hostname}:${portGateway}/management-parameters/api/v1`;
}
