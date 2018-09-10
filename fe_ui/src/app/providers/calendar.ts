import { Injectable } from '@angular/core';
import 'rxjs/add/operator/toPromise';
import { ApiProvider } from './api';

@Injectable()
export class CalendarProvider {
    constructor(private api: ApiProvider) { }

    /**
     * Save
     
    public save(vm) {
        return this.api.post('team/save', vm);
    }*/

    /**
     * Search all result
     * @param fromDate 
     * @param toDate 
     */
    public search(info:any) {
        return this.api.post('calendar/search',info);
    }

    /**
     * Get Team by Id
     *
     
    public getById(id: any) {
        return this.api.get('team/getById/' + id);
    }*/

    /**
     * Delete by Id
     
    public delete(id: any) {
        return this.api.delete('team/delete/' + id);
    }*/
}