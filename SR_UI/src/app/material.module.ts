import { NgModule } from "@angular/core";
// import { MatFormFieldModule,  
//     MatSelectModule, 
//     MatSidenavModule,  
//     MatListModule,
//     MatDatepickerModule, 
//     MatTabsModule, 
//     MatTableModule, 
//     MatBadgeModule, 
//     MatChipsModule, 
//     MatDividerModule,
//     MatCheckboxModule,
//     MatGridListModule,
//     MatExpansionModule,
//     MatButtonToggleModule,
//     MatNativeDateModule,
//     MatCardModule,
//     MatButtonModule,
//     MatMenuModule,
//     MatToolbarModule,
//     MatIconModule,
//     MatSliderModule,
// } from '@angular/material';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatButtonToggleModule} from '@angular/material/button-toggle';
import { MatTableModule } from '@angular/material/table';
import { MatBadgeModule} from '@angular/material/badge';
import { MatChipsModule } from '@angular/material/chips';
import { MatDividerModule } from '@angular/material/divider';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule} from '@angular/material/select';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule} from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatSliderModule } from '@angular/material/slider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatNativeDateModule } from '@angular/material/core';

@NgModule({
    imports:[
        MatFormFieldModule, 
        MatInputModule,
        MatButtonModule,
        MatSelectModule,
        MatSidenavModule,
        MatToolbarModule,
        MatDatepickerModule,
        MatListModule,
        MatTabsModule,
        MatIconModule,
        MatTableModule,
        MatBadgeModule,
        MatChipsModule,
        MatCardModule,
        MatButtonToggleModule,
        MatCheckboxModule,
        MatDividerModule,
        MatGridListModule,
        MatExpansionModule,
        MatNativeDateModule
    ],
    exports:[
        MatFormFieldModule, 
        MatInputModule,
        MatButtonModule,
        MatSelectModule,
        MatSidenavModule,
        MatToolbarModule,
        MatDatepickerModule,
        MatListModule,
        MatTabsModule,
        MatIconModule,
        MatTableModule,
        MatBadgeModule,
        MatButtonToggleModule,
        MatChipsModule,
        MatCardModule,
        MatCheckboxModule,
        MatDividerModule,
        MatGridListModule,
        MatExpansionModule,
    ]
})

export class MaterialModule{

}