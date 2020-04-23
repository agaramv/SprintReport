export class sprintReport{
    sprintStartDate:Date //Up to change object type
    sprintEndDate:Date //up to change object type
    teamId:number
    activeInd:string
    workCode:string
    workValue:string
    infoType:string
    supportInd:string
    valueInd:string
    newValueInd:string
    runInd:string
    growInd:string
    transformInd:string

    constructor(sprintStartDate:Date, sprintEndDate:Date, teamId:number, activeInd:string, workCode:string, workValue:string, infoType:string, supportInd:string, valueInd:string, newValueInd:string, runInd:string, growInd:string, transformInd:string){
        this.sprintStartDate=sprintStartDate
        this.sprintEndDate=sprintEndDate
        this.teamId=teamId;
        this.activeInd=activeInd;
        this.workCode=workCode;
        this.workValue=workValue;
        this.infoType=infoType;
        this.supportInd=supportInd;
        this.valueInd=valueInd; 
        this.newValueInd=newValueInd;
        this.runInd=runInd;
        this.growInd=growInd;
        this.transformInd=transformInd;
    }
}