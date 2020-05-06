export class Request{
    team_id: String;
    sprint_num: number;
    category: string;
    request_id: string;
    constructor(team_id: String, sprint_num: number, category: string, request_id: string){
        this.team_id=team_id;
        this.sprint_num=sprint_num;
        this.category=category;
        this.request_id=request_id;
    }
}