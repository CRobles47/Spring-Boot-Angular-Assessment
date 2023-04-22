export class User{
    userId: number=0;
    userName: string='';
    userAge: string='';
    userSalary: string='';

    constructor(
        name: string,
        age: string,
        salary: string
    ) {
        this.userName = name;
        this.userAge = age;
        this.userSalary = salary;
    }

}