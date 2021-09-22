package sprav;

public class Subscriber {
    private int id;
    private String FIO, Podrazdelenie, Kabinet, NS, ZS, PM, OtherTEL, Dopolnitel, OrganBezopasnosti, StrukturnoePodrazdelenie;

    public Subscriber(int id, String FIO, String podrazdelenie, String kabinet, String NS, String ZS, String PM, String otherTEL, String dopolnitel, String organBezopasnosti, String strukturnoePodrazdelenie) {
        this.id = id;
        this.FIO = FIO;
        Podrazdelenie = podrazdelenie;
        Kabinet = kabinet;
        this.NS = NS;
        this.ZS = ZS;
        this.PM = PM;
        OtherTEL = otherTEL;
        Dopolnitel = dopolnitel;
        OrganBezopasnosti = organBezopasnosti;
        StrukturnoePodrazdelenie = strukturnoePodrazdelenie;
    }

    public Subscriber() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getPodrazdelenie() {
        return Podrazdelenie;
    }

    public void setPodrazdelenie(String podrazdelenie) {
        Podrazdelenie = podrazdelenie;
    }

    public String getKabinet() {
        return Kabinet;
    }

    public void setKabinet(String kabinet) {
        Kabinet = kabinet;
    }

    public String getNS() {
        return NS;
    }

    public void setNS(String NS) {
        this.NS = NS;
    }

    public String getZS() {
        return ZS;
    }

    public void setZS(String ZS) {
        this.ZS = ZS;
    }

    public String getPM() {
        return PM;
    }

    public void setPM(String PM) {
        this.PM = PM;
    }

    public String getOtherTEL() {
        return OtherTEL;
    }

    public void setOtherTEL(String otherTEL) {
        OtherTEL = otherTEL;
    }

    public String getDopolnitel() {
        return Dopolnitel;
    }

    public void setDopolnitel(String dopolnitel) {
        Dopolnitel = dopolnitel;
    }

    public String getOrganBezopasnosti() {
        return OrganBezopasnosti;
    }

    public void setOrganBezopasnosti(String organBezopasnosti) {
        OrganBezopasnosti = organBezopasnosti;
    }

    public String getStrukturnoePodrazdelenie() {
        return StrukturnoePodrazdelenie;
    }

    public void setStrukturnoePodrazdelenie(String strukturnoePodrazdelenie) {
        StrukturnoePodrazdelenie = strukturnoePodrazdelenie;
    }
}
