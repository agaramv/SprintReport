export class Team{
    team_id:String;
    team_desc:String;
    parent_team_ind:String;
    scrum_master_email:String;
    project_ind:String;
    constructor(team_id:String, team_desc:String, parent_team_ind:String, scrum_master_email:String, project_ind:String){
        this.team_id=team_id;
        this.team_desc=team_desc;
        this.parent_team_ind=parent_team_ind;
        this.scrum_master_email=scrum_master_email;
        this.project_ind=project_ind;
    }
}