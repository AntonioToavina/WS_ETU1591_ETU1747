import { IonContent, IonHeader, IonItem, IonLabel, IonMenu, IonTitle, IonToolbar } from "@ionic/react"
import { useHistory } from "react-router"

const Menu: React.FC=()=>{

    const history=useHistory()

    const handleClick=(link:string)=>{
        history.push(link)
    }

    return(
        <IonMenu contentId="main-content">
            <IonHeader>
          <IonToolbar>
            <IonTitle>Menu Content</IonTitle>
          </IonToolbar>
        </IonHeader>
        <IonContent className="ion-padding"> 
            <IonItem>
                <IonLabel> <a onClick={()=>handleClick("/home")}>Home</a></IonLabel>
            </IonItem>
        </IonContent>
        
        </IonMenu>
    )
}

export default Menu