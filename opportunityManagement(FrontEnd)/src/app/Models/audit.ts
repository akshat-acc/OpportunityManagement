export class Audit {

    public Id: number;
    public managerEmail: String;
    public date: Date;
    public operation: string;
    public oldData: String;
    public newData: String;

    public constructor() {
    }
}