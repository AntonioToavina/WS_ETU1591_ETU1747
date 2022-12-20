import { IonContent, IonImg, IonItem, IonLabel, IonPage } from "@ionic/react";
import { useEffect } from "react";
import { useLocation, useParams } from "react-router"
import Picture from "./Picture";

const Details: React.FC =()=>{
    var storage=sessionStorage.getItem("fiche")
    const fiche=JSON.parse(storage || '{}')


    return (
        <IonPage>
            <h1>Fiche {fiche.matricule}</h1>
            <IonContent>
                <IonItem>
                    <IonImg style={{ 'border': '1px solid black', 'minHeight': '100px' }} src={"data:image/png;base64,"+fiche.img} ></IonImg>   
                </IonItem>
            <IonItem>
                <IonLabel>Modele : {fiche.modele.nommodele}</IonLabel>
                <IonLabel>Matricule : {fiche.matricule}</IonLabel>
            </IonItem>
            <IonItem>
                <IonLabel>Hauteur : {fiche.hauteur}</IonLabel>
                <IonLabel>Capacite : {fiche.capacite} sieges</IonLabel>
            </IonItem>
            <IonItem>
                <IonLabel>Carburant : {fiche.carburant} litres</IonLabel>
                <IonLabel>Fournisseur : {fiche.modele.company.nom}</IonLabel>
            </IonItem>
            <IonItem>
                <IonLabel>Vmax : {fiche.vmax} km/h</IonLabel>
            </IonItem>
            
            <h1>Historiques kilometrages</h1>
            <IonItem fill="solid">
                <IonLabel>Date</IonLabel>
                <IonLabel>Debut km</IonLabel>
                <IonLabel>Fin km</IonLabel>
            </IonItem>
            {fiche.kilometrages.map((element:any,index:number)=>(
                <IonItem key={index}>
                    <IonLabel>{element.datemodif}</IonLabel>
                    <IonLabel>{element.debutkm}</IonLabel>
                    <IonLabel>{element.finkm}</IonLabel>
                </IonItem>
            ))}

            <Picture id={fiche.idavion}/>
            </IonContent>
        </IonPage>
    )
}

export default Details