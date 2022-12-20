import { IonButton, IonButtons,  IonContent,IonHeader,IonInput,IonItem,IonLabel,IonMenuButton,IonPage, IonRow, IonTitle, IonToolbar} from '@ionic/react';
import './Home.css';
import { useEffect, useState } from 'react';
import { NavLink, useHistory } from 'react-router-dom';
import Menu from './Menu';
import Listes from '../../components/Listes';

const Home: React.FC = () => {
  const[avions , setAvions] =useState<any[]>([])
  const header=["idAvion", "Matricule", "Modele", "Company", "Vmax"]
  const [month,setMonth]=useState('20')

  useEffect(()=>{
    var content = {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        "Authorization":""
      },
    };

  var token=sessionStorage.getItem("user");
  token=token? JSON.parse(token).token : "vef345"

  content.headers.Authorization ="Bearer "+ token;
  
 fetch("http://localhost:8080/avions", content)
  .then((response) => response.json())
  .then((json) => {
    if("error" in json)
     window.location.href="/"
     
    setAvions(json.data)  
  })
  
},[])

  const handleClick=()=>{
    setMonth('20')
  }

  return (
    <>
    <Menu />
    <IonPage id="main-content">
      <IonHeader>
        <IonToolbar>
          <IonButtons slot="start">
            <IonMenuButton></IonMenuButton>
          </IonButtons>
          <IonTitle>Menu</IonTitle>
        </IonToolbar>
        </IonHeader>
      <IonContent>
        <h1>Listes des avions</h1>
        <IonLabel>Filtrer ici par mois le restant pour l'assurance</IonLabel>
        
        <IonItem fill='solid'>
        <IonInput type="number"  onIonChange={e => 
          setMonth(e.detail.value!)} ></IonInput>
        </IonItem>

        <IonButton fill="outline" onClick={handleClick}>Reset</IonButton>
        <br/>

        <IonItem fill='solid'>
          {header.map((element,index)=>(
              <IonLabel key={index}><strong>{element}</strong></IonLabel>
          ))}
        </IonItem>

        <Listes avions={avions} month={month}/>

      </IonContent>
    </IonPage>
    </>
    
  );
};

export default Home;
