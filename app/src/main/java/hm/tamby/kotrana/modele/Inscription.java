package hm.tamby.kotrana.modele;

public class Inscription {
    private String userName;
    private String userEmail;
    private String userMdp;

    /**constructeur
     *
     */
    public Inscription(){}
    public Inscription(String userName, String userEmail, String userMdp) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userMdp = userMdp;
    }

    /**getters
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserMdp() {
        return userMdp;
    }
    /**setters
     *
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserMdp(String userMdp) {
        this.userMdp = userMdp;
    }
}
