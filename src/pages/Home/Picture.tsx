import { IonContent, IonHeader, IonPage, IonItem,IonTitle, IonToolbar, IonImg, IonFab, IonFabButton, IonIcon, IonButton } from '@ionic/react';
import React, { Component, useEffect, useState } from 'react';
import {Camera, CameraResultType } from '@capacitor/camera';
import { Plugins } from '@capacitor/core';
import { defineCustomElements } from '@ionic/pwa-elements/loader';
import { useHistory } from 'react-router';

// const { Camera } = Plugins;

interface Container{
    id:any
}

const Picture:React.FC<Container>=(props)=>{
    const [photo,setPhoto]=useState('')
    const history=useHistory()
    defineCustomElements(window);

  const takePicture=async ()=> {
    const image = await Camera.getPhoto({
      quality: 90,
      allowEditing: false,
      resultType: CameraResultType.Base64
    })
    
   setPhoto(image.base64String?image.base64String:"tsity");
  }


useEffect(()=>{
    if(photo!=''){
        var content = {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
              "Authorization":""
            },
            body:""
        };
      
        var token=sessionStorage.getItem("user");
        token=token? JSON.parse(token).token : "vef345"
      
        content.headers.Authorization ="Bearer "+ token;
        content.body=photo
        
       fetch("http://localhost:8080/avions/"+props.id+"/picture", content).then(()=>{
        history.push("/home")
       })

    }
    
},[photo])
  
  return (
        <>
            <h1>Importer une nouvelle photo</h1>
          <IonImg style={{ 'border': '1px solid black', 'minHeight': '100px' }} src={''} ></IonImg>

          <IonFab color="primary" vertical="bottom" horizontal="center" slot="fixed">
            <IonButton color="primary" onClick={() =>takePicture()}>
              Importer
            </IonButton>
          </IonFab>
        </>
    );
  };

export default Picture;