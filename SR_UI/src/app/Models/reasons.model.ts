export class Reason{
    code:String;
    reason_desc:String;
    history_ind:String;
    constructor(code:String, reason_desc:String, history_ind:String){
        this.code=code;
        this.reason_desc=reason_desc;
        this.history_ind=history_ind;
    }
}