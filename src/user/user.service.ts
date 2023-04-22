import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class UserService {
    private url = "http://localhost:8080/api/users";

    constructor(private httpClient: HttpClient) { }
    
    getUsers(): Observable<any>{
        return this.httpClient.get(`${this.url}`);
    }

    createUser(user: Object): Observable<Object> {
        return this.httpClient.post(`${this.url}`, user)
    }

    updateUser(id: number, user: Object): Observable<Object> {
        return this.httpClient.put(`${this.url}/${id}`, user);
    }

    deleteUser(id: number): Observable<any> {
        return this.httpClient.delete(`${this.url}/${id}`);
    }
}