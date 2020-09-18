/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brain.controller;

import static brain.controller.DbConnect.disconnectDb;
import brain.models.ClsCaisse;
import brain.models.ClsDepense;
import brain.models.ClsLingneSouscription;
import brain.models.ClsCoiffure;
import brain.models.ClsJournalier;
import brain.models.ClsPaiement;
import brain.models.ClsSouscription;
import brain.models.ClsType;
import brain.models.ClsUser;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class ClsUpdate {
    
    public boolean updateData(Object obj) throws ClassNotFoundException, SQLException, Exception
    {
        if (obj instanceof ClsUser)
        {
            ClsUser user = (ClsUser)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_tuser ?,?,?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getPass());
            ps.setString(3, user.getAccreditation());
            ps.executeUpdate();
            DbConnect.disconnectDb();
            return true;
        }

        else if (obj instanceof ClsType)
        {
            ClsType type = (ClsType)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_ttype ?,?");
            ps.setInt(1, type.getId());
            ps.setString(2, type.getTypeItem());
            ps.executeUpdate();
            DbConnect.disconnectDb();
            return true;
        }

        else if (obj instanceof ClsSouscription)
        {
            ClsSouscription souscription = (ClsSouscription)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_tsouscription ?,?,?,?");
            ps.setInt(1, souscription.getId());
            ps.setDate(2, souscription.getDate_souscription());
            ps.setString(3, souscription.getClient());
            ps.setString(4, souscription.getUser().getName());
            ps.executeUpdate();
            DbConnect.disconnectDb();
            return true;
        }

        else if (obj instanceof ClsPaiement)
        {
            ClsPaiement paiement = (ClsPaiement)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_tpaiement ?,?,?,?,?");
            ps.setInt(1, paiement.getId());
            ps.setInt(2, paiement.getSouscription().getId());
            ps.setDate(3, paiement.getDate_paiement());
            ps.setFloat(4, paiement.getMontant());
            ps.setString(5, paiement.getUser().getName());
            ps.executeUpdate();
            DbConnect.disconnectDb();
            return true;
        }

        else if (obj instanceof ClsJournalier)
        {
            ClsJournalier journalier = (ClsJournalier)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_tjournalier ?,?,?,?,?,?,?,?,?");
            ps.setInt(1, journalier.getId());
            ps.setString(2, journalier.getNom());
            ps.setString(3, journalier.getPostnom());
            ps.setString(4, journalier.getPrenom());
            ps.setString(5, journalier.getLieu_naissance());
            ps.setDate(6, journalier.getDate_naissance());
            ps.setString(7, journalier.getEtat_civil());
            ps.setString(8, journalier.getPiece_identite());
            ps.setString(9, journalier.getNumero_piece_identite());
            ps.executeUpdate();
            DbConnect.disconnectDb();
            return true;
        }

        else if (obj instanceof ClsCoiffure)
        {
            ClsCoiffure coiffure = (ClsCoiffure)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_tcoiffure ?,?,?,?");
            ps.setInt(1, coiffure.getId());
            ps.setString(2, coiffure.getModele());
            ps.setString(3, coiffure.getTypeItem());
            ps.setFloat(4, coiffure.getMontant());
            ps.executeUpdate();
            DbConnect.disconnectDb();
            return true;
        }

        else if (obj instanceof ClsLingneSouscription)
        {
            ClsLingneSouscription ligne = (ClsLingneSouscription)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_tligne_souscription ?,?,?");
            ps.setInt(1, ligne.getSouscription().getId());
            ps.setInt(2, ligne.getCoiffure().getId());
            ps.setFloat(3, ligne.getQte());
            ps.executeUpdate();
            DbConnect.disconnectDb();
            return true;
        }

        else if (obj instanceof ClsDepense)
        {
            ClsDepense depense = (ClsDepense)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_tdepense ?,?,?,?,?,?");
            ps.setInt(1, depense.getId());
            ps.setString(2, depense.getIntitule());
            ps.setString(3, depense.getExecutant());
            ps.setFloat(4, depense.getMontant());
            ps.setDate(5, depense.getDate_depense());
            ps.setString(6, depense.getUser().getName());
            ps.executeUpdate();
            DbConnect.disconnectDb();
            return true;
        }

        else if (obj instanceof ClsCaisse)
        {
            ClsCaisse caisse = (ClsCaisse)obj;
            PreparedStatement ps = DbConnect.connectDb().prepareStatement("EXECUTE SP_UPDATE_tcaisse ?,?,?");
            ps.setInt(1, caisse.getId());
            ps.setFloat(2, caisse.getMontant());
            ps.setDate(3, caisse.getDate_update());
            ps.executeUpdate();
            DbConnect.disconnectDb();
            return true;
        }

        return false;
    }

    public static boolean fx_IdeleteData(String tbl, int id) throws ClassNotFoundException, SQLException, Exception
    {
        PreparedStatement ps = DbConnect.connectDb().prepareStatement
                                ("DELETE FROM " + tbl + "WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        DbConnect.disconnectDb();
        return true;
    }
    
    public static boolean fx_SdeleteData(String tbl, String id) throws ClassNotFoundException, SQLException, Exception
    {
        PreparedStatement ps = DbConnect.connectDb().prepareStatement("DELETE FROM " + tbl + "WHERE id = ?");
        ps.setString(1, id);
        ps.executeUpdate();
        DbConnect.disconnectDb();
        return true;
    }

}