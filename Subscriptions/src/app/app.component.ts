import { AfterViewInit, Component, ElementRef, NgZone, ViewChild } from '@angular/core';
import { StripeService } from './stripe.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit{
  
  title(title:any) {
    throw new Error('Method not implemented.');
  }

  @ViewChild('cardInfo')
  cardInfo!: ElementRef;
  cardError!: string;
  card: any;

  constructor(
    private ngZone: NgZone,
    private stripeService: StripeService
    ){ }

  ngAfterViewInit(){
    this.card = elements.create('card');
    this.card.mount(this.cardInfo.nativeElement);
    this.card.addEventListener('change', this.onChange.bind(this));
  }

  onChange({error} : {error: any}){
    if (error){
      this.ngZone.run(()=> this.cardError=error.message);
    } else {
      this.ngZone.run(()=> this.cardError='');
    }
  }

  async onClick(){
    const {token, error} = await stripe.createToken(this.card);
    if (token){
     const response = await this.stripeService.charge(100, token.id);
     console.log(response);
    } else {
      this.ngZone.run(()=> this.cardError=error.message);
    }
  }
  
}