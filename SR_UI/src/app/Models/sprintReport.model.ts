export class sprintReport{
    activeInd:string
    workCode:string
    workDesc:string
    infoType:string
    supportInd:string
    valueInd:string
    newValueInd:string
    runInd:string
    growInd:string
    transformInd:string

    constructor(activeInd:string, workCode:string, workDesc:string, infoType:string, supportInd:string, valueInd:string, newValueInd:string, runInd:string, growInd:string, transformInd:string){
        this.activeInd=activeInd;
        this.workCode=workCode;
        this.workDesc=workDesc;
        this.infoType=infoType;
        this.supportInd=supportInd;
        this.valueInd=valueInd; 
        this.newValueInd=newValueInd;
        this.runInd=runInd;
        this.growInd=growInd;
        this.transformInd=transformInd;
    }
}