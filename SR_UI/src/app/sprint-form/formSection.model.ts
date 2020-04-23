import { formElem } from './formElem.model'

export class formSection {
    title:String
    formElems:formElem[]

    constructor(title:String, formElems:formElem[]){
        this.title=title;
        this.formElems=formElems;
    }
}