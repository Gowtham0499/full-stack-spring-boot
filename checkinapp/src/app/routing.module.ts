import { ConfirmcheckinComponent } from './components/confirmcheckin/confirmcheckin.component';
import { CheckinComponent } from './components/checkin/checkin.component';
import { StartcheckinComponent } from './components/startcheckin/startcheckin.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes:Routes = [
    {
        path: '',
        redirectTo: '',
        pathMatch: 'full'
    },
    {
        path: 'startcheckin',
        component: StartcheckinComponent
    },
    {
        path: 'checkin/:id',
        component: CheckinComponent
    },
    {
        path: 'confirm',
        component: ConfirmcheckinComponent
    }
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRouterModule{}