public class Document {  
    protected String titre;  
    protected int id;  
    protected int np;  
    protected String type;

    public Document(String t, int i, int np) {  
        this.titre = t;  
        this.id = i;  
        this.np = np;  
    }

    public void edition() {  
        System.out.println("Le type de document est " + this.type + 
                           ", les caractéristiques : id=" + this.id + 
                           ", np=" + this.np + 
                           ", titre=" + this.titre);  
    }

    String getType() {  
        return this.type;  
    }  
}

class Article extends Document {  
    private String nomAuteur;

    public Article(String t, int id, int np, String nomAuteur) {  
        super(t, id, np); 
        this.nomAuteur = nomAuteur;  
        this.type = "article"; 
    }

    public void edition() {  
        super.edition(); 
        System.out.println("Le nom de l'auteur est " + this.nomAuteur);  
    }   
}

class Livre extends Article {
    private String nomEditeur;

    public Livre(String t, int id, int np, String nomAuteur, String nomEditeur) {
        super(t, id, np, nomAuteur);
        this.nomEditeur = nomEditeur;
        this.type = "livre";
    }

    String getNomEditeur() {
        return this.nomEditeur;
    }

    public void edition() {
        super.edition();
        System.out.println("Le nom de l'éditeur est " + this.nomEditeur);
    }
}

class Periodique extends Document {
    private int freq;

    public Periodique(String t, int id, int np, int freq) {
        super(t, id, np);
        this.freq = freq;
        this.type = "periodique";
    }

    int getFreq() {
        return this.freq;
    }

    public void edition() {
        super.edition();
        System.out.println("La fréquence de parution est " + this.freq);
    }   
}

class Bibliotheque {
    private Document[] listdoc;
    private int capa;
    private int nd;

    public Bibliotheque(int n) {
        this.capa = n;
        listdoc = new Document[capa];
        this.nd = 0;
    }

    int getCapacite() {
        return this.capa;
    }

    void ajoutDoc(Document d) {
        if (nd < capa) {
            listdoc[nd] = d;
            nd++;
        } else {
            System.out.println("Le tableau est complet");
        }
    }

    void supprimDoc(int num) {
        boolean test = false;
        for (int i = 0; i < nd; i++) {
            if (listdoc[i].id == num) {
                for (int j = i; j < nd - 1; j++) {
                    listdoc[j] = listdoc[j + 1];
                }
                listdoc[nd - 1] = null;
                nd--;
                test = true;
                break;
            }
        }
        if (!test) {
            System.out.println("Document non trouvé.");
        }
    }

    int getNombreDocument() {
        return this.nd;
    }

    Bibliotheque listLivres() {
        Bibliotheque biblioLivres = new Bibliotheque(nd);
        for (int i = 0; i < nd; i++) {
            if (listdoc[i].getType().equals("livre")) {
                biblioLivres.ajoutDoc(listdoc[i]);
            }
        }
        return biblioLivres;
    }

    Bibliotheque listArticles() {
        Bibliotheque biblioArticles = new Bibliotheque(nd);
        for (int i = 0; i < nd; i++) {
            if (listdoc[i].getType().equals("article")) {
                biblioArticles.ajoutDoc(listdoc[i]);
            }
        }
        return biblioArticles;
    }

    Bibliotheque listDocumentsSimples() {
        Bibliotheque biblioSimples = new Bibliotheque(nd);
        for (int i = 0; i < nd; i++) {
            if (listdoc[i] instanceof Document)
            		//listdoc[i].getType().equals("document")) {
                biblioSimples.ajoutDoc(listdoc[i]);
            
        }
        return biblioSimples;
    }

    Bibliotheque listPeriodiques() {
        Bibliotheque biblioPeriodiques = new Bibliotheque(nd);
        for (int i = 0; i < nd; i++) {
            if (listdoc[i].getType().equals("periodique")) {
                biblioPeriodiques.ajoutDoc(listdoc[i]);
            }
        }
        return biblioPeriodiques;
    }
    
    public static void main(String[] args) {
      
        Article a1 = new Article("T 1", 1, 100, "A 1");
        Article a2 = new Article("T2", 2, 120, "A2");
        Livre l1 = new Livre("harry potter 1", 3, 200, "Auteur 3", "Edi 1");
        Livre l2 = new Livre("harry potter 2", 4, 250, "Auteur 4", "Ed 2");
        Periodique p1 = new Periodique(" Periodique 1", 5, 30, 12);
        
       
        Bibliotheque bibliotheque = new Bibliotheque(10);
        
    
        bibliotheque.ajoutDoc(a1);
        bibliotheque.ajoutDoc(a2);
        bibliotheque.ajoutDoc(l1);
        bibliotheque.ajoutDoc(l2);
        bibliotheque.ajoutDoc(p1);
        
  
        System.out.println("Nombre total document : " + bibliotheque.getNombreDocument());
        
  
        bibliotheque.supprimDoc(2);
        System.out.println("Apr supp, nombre de documents : " + bibliotheque.getNombreDocument());
       
   
        Bibliotheque livres = bibliotheque.listLivres();
        System.out.println("Liste des livres :");
        /*for (int i = 0; i < livres.getNombreDocument(); i++) {
            livres.listdoc[i].edition();
        }*/
        livres.in
        
        Bibliotheque articles = bibliotheque.listArticles();
        System.out.println("Liste des articles :");
        for (int i = 0; i < articles.getNombreDocument(); i++) {
            articles.listdoc[i].edition();
        }
        
        Bibliotheque periodiques = bibliotheque.listPeriodiques();
        System.out.println("Liste des périodiques :");
        for (int i = 0; i < periodiques.getNombreDocument(); i++) {
            periodiques.listdoc[i].edition();
        }
    }
}
