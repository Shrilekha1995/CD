import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

import { AppComponent } from "./app.component";
import { HomeComponent } from "./components/home/home.component";
import { SignupComponent } from "./components/signup/signup.component";
import { LoginComponent } from "./components/login/login.component";
import { AdmindashboardComponent } from "./components/admindashboard/admindashboard.component";
import { UserdashboardComponent } from "./components/userdashboard/userdashboard.component";
import { ROUTES } from "./app.routes";
import { AuthGuard } from "./auth.guard";

import { FormsModule } from "@angular/forms";
import { RouterModule } from "@angular/router";
import { NavigationComponent } from "./components/navigation/navigation.component";
import { HttpClientModule } from "@angular/common/http";

import { UserService } from "./services/user.service";
import { LoginAuthService } from "./services/login-auth.service";
import { SideNavComponent } from "./side-nav/side-nav.component";
import { LayoutModule } from "@angular/cdk/layout";
import {
  MatToolbarModule,
  MatButtonModule,
  MatSidenavModule,
  MatIconModule,
  MatListModule
} from "@angular/material";
import { UserdetailsComponent } from "./components/userdetails/userdetails.component";
import { AdminSideNavComponent } from "./admin-side-nav/admin-side-nav.component";

import { ListComponent } from "./components/list/list.component";
import { CoursesComponent } from "./components/courses/courses.component";
import { AllCoursesComponent } from "./components/all-courses/all-courses.component";
import { ScheduleComponent } from "./components/schedule/schedule.component";
import { NgbdCarouselConfig } from "./components/image-slider/image-slider.component";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { AttendanceComponent } from "./components/attendance/attendance.component";
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { ServicesComponent } from './components/services/services.component';
import { ShowScheduleComponent } from './components/show-schedule/show-schedule.component';
import { AddressComponent } from './components/address/address.component';
import { RoomDetailsComponent } from './components/room-details/room-details.component';
import { CourseIdFormComponent } from './components/course-id-form/course-id-form.component';
import { FacultydashboardComponent } from './components/facultydashboard/facultydashboard.component';
import { CancelClassComponent } from './components/cancel-class/cancel-class.component';
import { FacultySideNavComponent } from "./components/faculty-side-nav/faculty-side-nav.component";
import { ViewAttendanceDetsComponent } from './components/view-attendance-dets/view-attendance-dets.component';
import { NavCompComponent } from './nav-comp/nav-comp.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SignupComponent,
    LoginComponent,
    AdmindashboardComponent,
    UserdashboardComponent,
    NavigationComponent,
    SideNavComponent,
    UserdetailsComponent,
    AdminSideNavComponent,
    ListComponent,
    CoursesComponent,
    AllCoursesComponent,
    ScheduleComponent,
    NgbdCarouselConfig,
    AttendanceComponent,
    AboutComponent,
    ContactComponent,
    ServicesComponent,
    ShowScheduleComponent,
    AddressComponent,
    RoomDetailsComponent,
    CourseIdFormComponent,
    FacultydashboardComponent,
    CancelClassComponent,
    FacultySideNavComponent,
    ViewAttendanceDetsComponent,
    NavCompComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(ROUTES, { enableTracing: true }),
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    BrowserAnimationsModule,
    NgbModule
  ],
  providers: [UserService, AuthGuard, LoginAuthService],
  bootstrap: [AppComponent]
})
export class AppModule {}
