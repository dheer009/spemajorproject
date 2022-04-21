import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router'; 
// import { LoginComponent } from './components/login/login.component';
// import { WelcomeComponent } from './components/welcome/welcome.component';
import { ErrorComponent } from './components/error/error.component';
// import { SignupComponent } from './pages/signup/signup.component';
import { RegistrationComponent } from './components/registration/registration.component';
const routes: Routes=[
  // { path: '', component: LoginComponent  },
  // { path:'signup', component: SignupComponent, pathMatch: 'full'},
  // { path: 'login', component: LoginComponent  },//canActivate, RouteGuardService
  // { path: 'welcome/:name', component: WelcomeComponent },
  {path : 'register', component : RegistrationComponent,pathMatch: 'full'},
  { path:'**', component: ErrorComponent}
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }