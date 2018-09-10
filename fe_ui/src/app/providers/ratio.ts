import { Injectable } from '@angular/core';
import 'rxjs/add/operator/toPromise';
import { ApiProvider } from './api';

@Injectable()
export class RatioProvider {
    constructor(private api: ApiProvider) { }

    /**
     * Save
     */
    public save(vm) {
        return this.api.post('ratio/save', vm);
    }

    /**
     * Search all result
     * @param info 
     */
    public search() {
        return this.api.get('ratio/search');
    }

    /**
     * Get by calendar
     * @param id 
     */
    public getByCal(id: any) {
        return this.api.get('ratio/search-by-calendar/' + id);
    }

    /**
     * Get Team by Id
     *
     */
    public getById(id: any) {
        return this.api.get('ratio/getById/' + id);
    }

    /**
     * Delete by Id
     */
    public delete(id: any) {
        return this.api.delete('ratio/delete/' + id);
    }
}