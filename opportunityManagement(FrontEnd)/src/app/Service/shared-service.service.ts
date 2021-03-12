import { Injectable } from '@angular/core';
import { Opportunity } from '../Models/opportunity';

@Injectable({
  providedIn: 'root'
})
export class SharedServiceService {

  editOpportunity:Opportunity;
  id:number;

  constructor() { }

  setEditOpportunity(opportunity){
    this.editOpportunity = opportunity;
  }

  getEditOpportunity(){
    return this.editOpportunity;
  }

  setOpportunityId(id){
    this.id=id;
  }

  getOpportunityId(){
    return this.id;
  }
}




// export class SharedService {

//   id: Number;

//   vid:Number;

//   editVideo: DBFile;

//   constructor() { }

//   setVid(vid){
//     this.vid = vid;
//   }

//   getVid(){
//     return this.vid;
//   }

//   setUserId(id) {
//     this.id = id;
//   }

//   getUserId(){
//     return this.id;
//   }

//   setEditVideo(video){
//     this.editVideo = video;
//   }

//   getEditVideo(){
//     return this.editVideo;
//   }
  
// }
