import { style } from '@angular/animations';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  title = 'farmers2home-angular';

  themeMode = true;

  toggleTheme(){
      this.themeMode = !this.themeMode;
  }
}
