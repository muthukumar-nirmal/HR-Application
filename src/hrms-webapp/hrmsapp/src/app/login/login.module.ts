import { ModuleWithProviders, NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './login.component';
import { SharedModule } from '../shared/shared.module';



const authRouting: ModuleWithProviders = RouterModule.forChild([
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: LoginComponent
  }
]);

@NgModule({
  imports: [
    authRouting,
    SharedModule
  ],
  declarations: [
    LoginComponent
  ],

  providers: []
})
export class LoginModule {}