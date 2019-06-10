import { Component, OnInit } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-image-slider',
  templateUrl: './image-slider.component.html',
  styleUrls: ['./image-slider.component.css'],
  providers: [NgbCarouselConfig]  // add NgbCarouselConfig to the component providers
})


export class NgbdCarouselConfig {
 images = [0].map(() => `assets/images/img1.jpg`);
 images1 = [0].map(() => `assets/images/img2.png`);
 images2 = [0].map(() => `assets/images/img3.jpg`);
 images3 = [0].map(() => `assets/images/img4.png`);
 images4 = [0].map(() => `assets/images/img5.jpg`);
 images5 = [0].map(() => `assets/images/img6.jpg`);

 constructor(config: NgbCarouselConfig) {
    // customize default values of carousels used by this component tree
    config.interval = 2000;
    config.wrap = true;
    config.keyboard = false;
    config.pauseOnHover = true;
    
  }
}

