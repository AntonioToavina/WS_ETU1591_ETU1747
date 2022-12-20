import { IonItem, IonLabel, IonPage } from "@ionic/react"
import { useHistory } from "react-router"

interface Container{
    avions: any[],
    month:string
}

const Listes:React.FC <Container>=( props  ) =>{
    const history=useHistory()

    const handleClick=(fiche:string)=>{
        sessionStorage.setItem("fiche",fiche)
        history.push("/details")
    }

    return (
        <>  
            {props.avions?.filter((element)=>element.assurance[0].restant<=parseInt(props.month))
            .map((element,index)=>(
                <IonItem key={index}>
                  <IonLabel> <a onClick={()=>handleClick(JSON.stringify(element))}>{element.idavion}</a></IonLabel>
                  <IonLabel> {element.matricule}</IonLabel>
                  <IonLabel>{element.modele.nommodele}</IonLabel>
                  <IonLabel>{element.vmax} km/h</IonLabel>
                </IonItem>
            ))
          }
        </>
    )
} 

export default Listes