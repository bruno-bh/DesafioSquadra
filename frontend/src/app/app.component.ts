import { SistemaFilterDTO } from './dto/sistemaFilterdto';
import { SistemaService } from './sistema.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Sistema } from './sistema';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public sistemas: Sistema[];
  public filterDTO: SistemaFilterDTO = new SistemaFilterDTO();
  myimage: string = 'assets/images/teste.png';
  @ViewChild('filterForm') filterForm;



  constructor(private sistemaService: SistemaService) { }

  // tslint:disable-next-line: typedef
  ngOnInit() {
    this.getSistemas(this.filterDTO);
  }

  public getSistemas(filterDTO: SistemaFilterDTO): void {
    // tslint:disable-next-line: deprecation
    this.sistemaService.getAllSistemas(filterDTO).subscribe(
      (response: Sistema[]) => {
        this.sistemas = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddSistema(addForm: NgForm): void {
    document.getElementById('new-sistema-form').click();
    this.sistemaService.newSistema(addForm.value).subscribe(
      (response: Sistema) => {
        console.log(response);
        this.getSistemas(this.filterDTO);
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );

  }

  public onFilterForm(filterForm: NgForm): void {
    this.sistemaService.getAllSistemas(filterForm.value).subscribe(
      (response: Sistema[]) => {
        console.log(response);
        console.log(filterForm);
        this.sistemas = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );

  }

  public clearFilter(): void {
    this.filterForm.reset();
    this.filterForm.value.email = '';
    this.filterForm.value.descricao = '';
    this.filterForm.value.sigla = '';
   console.log('passou aqui carai');

  }


}
