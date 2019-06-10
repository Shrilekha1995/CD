import { Routes } from "@angular/router";
import { HomeComponent } from "./components/home/home.component";
import { SignupComponent } from "./components/signup/signup.component";
import { LoginComponent } from "./components/login/login.component";
import { AdmindashboardComponent } from "./components/admindashboard/admindashboard.component";
import { UserdashboardComponent } from "./components/userdashboard/userdashboard.component";
import { AuthGuard } from "./auth.guard";
import { UserdetailsComponent } from "./components/userdetails/userdetails.component";
import { ListComponent } from "./components/list/list.component";
import { CoursesComponent } from "./components/courses/courses.component";
import { AllCoursesComponent } from "./components/all-courses/all-courses.component";
import { ScheduleComponent } from "./components/schedule/schedule.component";
import { AttendanceComponent } from "./components/attendance/attendance.component";
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { ServicesComponent } from './components/services/services.component';
import { AddressComponent } from './components/address/address.component';
import { RoomDetailsComponent } from './components/room-details/room-details.component';
import { CourseIdFormComponent } from './components/course-id-form/course-id-form.component';
import { ShowScheduleComponent } from './components/show-schedule/show-schedule.component';
import { FacultydashboardComponent } from "./components/facultydashboard/facultydashboard.component";
import { CancelClassComponent } from "./components/cancel-class/cancel-class.component";
import {ViewAttendanceDetsComponent } from './components/view-attendance-dets/view-attendance-dets.component';

export const ROUTES: Routes = [
  {
    path: "home",
    component: HomeComponent
  },
  {
    path: "signup",
    component: SignupComponent
  },
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "details",
    component: UserdetailsComponent
  },
  {
    path: "list",
    component: ListComponent
  },
  {
    path: "admindashboard",
    component: AdmindashboardComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "userdashboard",
    component: UserdashboardComponent,
    canActivate: [AuthGuard]
  },
  {
    path: "allcourse",
    component: AllCoursesComponent
  },
  {
    path: "courses",
    component: CoursesComponent
  },
  {
    path: "schedule",
    component: ScheduleComponent
  },
  {
    path: "attendance",
    component: AttendanceComponent
  },
  {
    path: "about",
    component: AboutComponent
  },
  {
      path:"contact",
      component: ContactComponent
  },
  {
    path:"services",
    component: ServicesComponent
},
{
    path: 'address',
    component: AddressComponent
},
{
    path: 'room',
    component:RoomDetailsComponent
},
{
    path: 'showSchedule',
    component: ShowScheduleComponent
},
{
    path: 'inputCourseId',
    component:CourseIdFormComponent
},
{
  path: 'facultydashboard',
  component:FacultydashboardComponent
},
{
  path: 'cancelClass',
  component:CancelClassComponent
},
{
  path: 'addModule',
  component:CourseIdFormComponent
},
{
  path: 'viewAttendance',
  component:ViewAttendanceDetsComponent
},

  {
    path: "**",
    pathMatch: "full",
    redirectTo: "home"
  }
];
