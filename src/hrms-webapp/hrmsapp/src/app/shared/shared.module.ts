
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [
      CommonModule,
      FormsModule,
      ReactiveFormsModule,
      RouterModule
    ],
    declarations: [],
    exports: [
      CommonModule,
      FormsModule,
      ReactiveFormsModule,
      RouterModule
    ]
  })
  export class SharedModule {}