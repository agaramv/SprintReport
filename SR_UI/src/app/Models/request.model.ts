export class Request{
    category: string;
    request_id: string;
    request_short_desc:string;
    request_desc:string;
    date_started:string;
    date_completed:string;
    date_implemented:string;
    outcome:string;
    status:string;
    constructor(category: string, request_id: string, request_short_desc:string, request_desc:string, date_started:string, date_completed:string, date_implemented:string, outcome:string, status:string){
        this.category=category;
        this.request_id=request_id;
        this.request_short_desc=request_short_desc;
        this.request_desc=request_desc;
        this.date_started=date_started;
        this.date_completed=date_completed;
        this.date_implemented=date_implemented;
        this.outcome=outcome;
        this.status=status;
    }
}