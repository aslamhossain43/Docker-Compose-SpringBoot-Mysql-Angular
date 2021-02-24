export interface IEmployee {
    id?: number;
    name?: string;
    address?: string;
  }
  
  export class Employee implements IEmployee {
    constructor(public id?: number, public name?: string,address?: string) {}
  }
  