import { Injectable } from '@angular/core';
import 'rxjs/add/operator/toPromise';
import { ApiProvider } from './api';

@Injectable()
export class BetProvider {
    constructor(private api: ApiProvider) { }

    /**
     * Save
     */
    public save(vmBet) {
        return this.api.post('bet/save', vmBet);
    }

    /**
     * Get Team by Id
     *
     */
    public getById(id: any) {
        return this.api.get('bet/getById/' + id);
    }

    /**
     * Delete by Id
     */
    public delete(id: any) {
        return this.api.delete('bet/delete/' + id);
    }

    /**
     * Save
     */
    public saveguess(vmchampion) {
        return this.api.post('bet/saveGuess', vmchampion);
    }
}