/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author cleiton
 */
@Entity
@Table(name = "GABARITO_VESTIBULAR")
public class Gabarito_Vestibular implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "GABARITO_ID", nullable = false)
    private Integer gabarito_id;
    @Column(name = "GABARITO_DATACAD", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gabarito_datacad;

    @Column(name = "GABARITO_1", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_1;
    @Column(name = "GABARITO_2", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_2;
    @Column(name = "GABARITO_3", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_3;
    @Column(name = "GABARITO_4", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_4;
    @Column(name = "GABARITO_5", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_5;
    @Column(name = "GABARITO_6", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_6;
    @Column(name = "GABARITO_7", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_7;
    @Column(name = "GABARITO_8", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_8;
    @Column(name = "GABARITO_9", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_9;
    @Column(name = "GABARITO_10", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_10;
    @Column(name = "GABARITO_11", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_11;
    @Column(name = "GABARITO_12", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_12;
    @Column(name = "GABARITO_13", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_13;
    @Column(name = "GABARITO_14", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_14;
    @Column(name = "GABARITO_15", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_15;
    @Column(name = "GABARITO_16", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_16;
    @Column(name = "GABARITO_17", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_17;
    @Column(name = "GABARITO_18", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_18;
    @Column(name = "GABARITO_19", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_19;
    @Column(name = "GABARITO_20", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_20;
    @Column(name = "GABARITO_21", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_21;
    @Column(name = "GABARITO_22", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_22;
    @Column(name = "GABARITO_23", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_23;
    @Column(name = "GABARITO_24", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_24;
    @Column(name = "GABARITO_25", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_25;
    @Column(name = "GABARITO_26", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_26;
    @Column(name = "GABARITO_27", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_27;
    @Column(name = "GABARITO_28", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_28;
    @Column(name = "GABARITO_29", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_29;
    @Column(name = "GABARITO_30", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_30;
    @Column(name = "GABARITO_31", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_31;
    @Column(name = "GABARITO_32", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_32;
    @Column(name = "GABARITO_33", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_33;
    @Column(name = "GABARITO_34", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_34;
    @Column(name = "GABARITO_35", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_35;
    @Column(name = "GABARITO_36", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_36;
    @Column(name = "GABARITO_37", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_37;
    @Column(name = "GABARITO_38", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_38;
    @Column(name = "GABARITO_39", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_39;
    @Column(name = "GABARITO_40", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_40;
    @Column(name = "GABARITO_41", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_41;
    @Column(name = "GABARITO_42", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_42;
    @Column(name = "GABARITO_43", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_43;
    @Column(name = "GABARITO_44", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_44;
    @Column(name = "GABARITO_45", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_45;
    @Column(name = "GABARITO_46", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_46;
    @Column(name = "GABARITO_47", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_47;
    @Column(name = "GABARITO_48", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_48;
    @Column(name = "GABARITO_49", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_49;
    @Column(name = "GABARITO_50", nullable = true, columnDefinition = "CHAR(1)")
    private String gabarito_50;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_VESTIBULAR_GABARITO")
    @JoinColumn(name = "VESTIBULAR_INFO", referencedColumnName = "vestibular_info")
    private Vestibular vestibular;

    public Gabarito_Vestibular() {
        this.vestibular = new Vestibular();
    }

    public Integer getGabarito_id() {
        return gabarito_id;
    }

    public void setGabarito_id(Integer gabarito_id) {
        this.gabarito_id = gabarito_id;
    }

    public Date getGabarito_datacad() {
        return gabarito_datacad;
    }

    public void setGabarito_datacad(Date gabarito_datacad) {
        this.gabarito_datacad = gabarito_datacad;
    }

    public String getGabarito_1() {
        return gabarito_1;
    }

    public void setGabarito_1(String gabarito_1) {
        this.gabarito_1 = gabarito_1;
    }

    public String getGabarito_2() {
        return gabarito_2;
    }

    public void setGabarito_2(String gabarito_2) {
        this.gabarito_2 = gabarito_2;
    }

    public String getGabarito_3() {
        return gabarito_3;
    }

    public void setGabarito_3(String gabarito_3) {
        this.gabarito_3 = gabarito_3;
    }

    public String getGabarito_4() {
        return gabarito_4;
    }

    public void setGabarito_4(String gabarito_4) {
        this.gabarito_4 = gabarito_4;
    }

    public String getGabarito_5() {
        return gabarito_5;
    }

    public void setGabarito_5(String gabarito_5) {
        this.gabarito_5 = gabarito_5;
    }

    public String getGabarito_6() {
        return gabarito_6;
    }

    public void setGabarito_6(String gabarito_6) {
        this.gabarito_6 = gabarito_6;
    }

    public String getGabarito_7() {
        return gabarito_7;
    }

    public void setGabarito_7(String gabarito_7) {
        this.gabarito_7 = gabarito_7;
    }

    public String getGabarito_8() {
        return gabarito_8;
    }

    public void setGabarito_8(String gabarito_8) {
        this.gabarito_8 = gabarito_8;
    }

    public String getGabarito_9() {
        return gabarito_9;
    }

    public void setGabarito_9(String gabarito_9) {
        this.gabarito_9 = gabarito_9;
    }

    public String getGabarito_10() {
        return gabarito_10;
    }

    public void setGabarito_10(String gabarito_10) {
        this.gabarito_10 = gabarito_10;
    }

    public String getGabarito_11() {
        return gabarito_11;
    }

    public void setGabarito_11(String gabarito_11) {
        this.gabarito_11 = gabarito_11;
    }

    public String getGabarito_12() {
        return gabarito_12;
    }

    public void setGabarito_12(String gabarito_12) {
        this.gabarito_12 = gabarito_12;
    }

    public String getGabarito_13() {
        return gabarito_13;
    }

    public void setGabarito_13(String gabarito_13) {
        this.gabarito_13 = gabarito_13;
    }

    public String getGabarito_14() {
        return gabarito_14;
    }

    public void setGabarito_14(String gabarito_14) {
        this.gabarito_14 = gabarito_14;
    }

    public String getGabarito_15() {
        return gabarito_15;
    }

    public void setGabarito_15(String gabarito_15) {
        this.gabarito_15 = gabarito_15;
    }

    public String getGabarito_16() {
        return gabarito_16;
    }

    public void setGabarito_16(String gabarito_16) {
        this.gabarito_16 = gabarito_16;
    }

    public String getGabarito_17() {
        return gabarito_17;
    }

    public void setGabarito_17(String gabarito_17) {
        this.gabarito_17 = gabarito_17;
    }

    public String getGabarito_18() {
        return gabarito_18;
    }

    public void setGabarito_18(String gabarito_18) {
        this.gabarito_18 = gabarito_18;
    }

    public String getGabarito_19() {
        return gabarito_19;
    }

    public void setGabarito_19(String gabarito_19) {
        this.gabarito_19 = gabarito_19;
    }

    public String getGabarito_20() {
        return gabarito_20;
    }

    public void setGabarito_20(String gabarito_20) {
        this.gabarito_20 = gabarito_20;
    }

    public String getGabarito_21() {
        return gabarito_21;
    }

    public void setGabarito_21(String gabarito_21) {
        this.gabarito_21 = gabarito_21;
    }

    public String getGabarito_22() {
        return gabarito_22;
    }

    public void setGabarito_22(String gabarito_22) {
        this.gabarito_22 = gabarito_22;
    }

    public String getGabarito_23() {
        return gabarito_23;
    }

    public void setGabarito_23(String gabarito_23) {
        this.gabarito_23 = gabarito_23;
    }

    public String getGabarito_24() {
        return gabarito_24;
    }

    public void setGabarito_24(String gabarito_24) {
        this.gabarito_24 = gabarito_24;
    }

    public String getGabarito_25() {
        return gabarito_25;
    }

    public void setGabarito_25(String gabarito_25) {
        this.gabarito_25 = gabarito_25;
    }

    public String getGabarito_26() {
        return gabarito_26;
    }

    public void setGabarito_26(String gabarito_26) {
        this.gabarito_26 = gabarito_26;
    }

    public String getGabarito_27() {
        return gabarito_27;
    }

    public void setGabarito_27(String gabarito_27) {
        this.gabarito_27 = gabarito_27;
    }

    public String getGabarito_28() {
        return gabarito_28;
    }

    public void setGabarito_28(String gabarito_28) {
        this.gabarito_28 = gabarito_28;
    }

    public String getGabarito_29() {
        return gabarito_29;
    }

    public void setGabarito_29(String gabarito_29) {
        this.gabarito_29 = gabarito_29;
    }

    public String getGabarito_30() {
        return gabarito_30;
    }

    public void setGabarito_30(String gabarito_30) {
        this.gabarito_30 = gabarito_30;
    }

    public String getGabarito_31() {
        return gabarito_31;
    }

    public void setGabarito_31(String gabarito_31) {
        this.gabarito_31 = gabarito_31;
    }

    public String getGabarito_32() {
        return gabarito_32;
    }

    public void setGabarito_32(String gabarito_32) {
        this.gabarito_32 = gabarito_32;
    }

    public String getGabarito_33() {
        return gabarito_33;
    }

    public void setGabarito_33(String gabarito_33) {
        this.gabarito_33 = gabarito_33;
    }

    public String getGabarito_34() {
        return gabarito_34;
    }

    public void setGabarito_34(String gabarito_34) {
        this.gabarito_34 = gabarito_34;
    }

    public String getGabarito_35() {
        return gabarito_35;
    }

    public void setGabarito_35(String gabarito_35) {
        this.gabarito_35 = gabarito_35;
    }

    public String getGabarito_36() {
        return gabarito_36;
    }

    public void setGabarito_36(String gabarito_36) {
        this.gabarito_36 = gabarito_36;
    }

    public String getGabarito_37() {
        return gabarito_37;
    }

    public void setGabarito_37(String gabarito_37) {
        this.gabarito_37 = gabarito_37;
    }

    public String getGabarito_38() {
        return gabarito_38;
    }

    public void setGabarito_38(String gabarito_38) {
        this.gabarito_38 = gabarito_38;
    }

    public String getGabarito_39() {
        return gabarito_39;
    }

    public void setGabarito_39(String gabarito_39) {
        this.gabarito_39 = gabarito_39;
    }

    public String getGabarito_40() {
        return gabarito_40;
    }

    public void setGabarito_40(String gabarito_40) {
        this.gabarito_40 = gabarito_40;
    }

    public String getGabarito_41() {
        return gabarito_41;
    }

    public void setGabarito_41(String gabarito_41) {
        this.gabarito_41 = gabarito_41;
    }

    public String getGabarito_42() {
        return gabarito_42;
    }

    public void setGabarito_42(String gabarito_42) {
        this.gabarito_42 = gabarito_42;
    }

    public String getGabarito_43() {
        return gabarito_43;
    }

    public void setGabarito_43(String gabarito_43) {
        this.gabarito_43 = gabarito_43;
    }

    public String getGabarito_44() {
        return gabarito_44;
    }

    public void setGabarito_44(String gabarito_44) {
        this.gabarito_44 = gabarito_44;
    }

    public String getGabarito_45() {
        return gabarito_45;
    }

    public void setGabarito_45(String gabarito_45) {
        this.gabarito_45 = gabarito_45;
    }

    public String getGabarito_46() {
        return gabarito_46;
    }

    public void setGabarito_46(String gabarito_46) {
        this.gabarito_46 = gabarito_46;
    }

    public String getGabarito_47() {
        return gabarito_47;
    }

    public void setGabarito_47(String gabarito_47) {
        this.gabarito_47 = gabarito_47;
    }

    public String getGabarito_48() {
        return gabarito_48;
    }

    public void setGabarito_48(String gabarito_48) {
        this.gabarito_48 = gabarito_48;
    }

    public String getGabarito_49() {
        return gabarito_49;
    }

    public void setGabarito_49(String gabarito_49) {
        this.gabarito_49 = gabarito_49;
    }

    public String getGabarito_50() {
        return gabarito_50;
    }

    public void setGabarito_50(String gabarito_50) {
        this.gabarito_50 = gabarito_50;
    }

    public Vestibular getVestibular() {
        return vestibular;
    }

    public void setVestibular(Vestibular vestibular) {
        this.vestibular = vestibular;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.gabarito_id != null ? this.gabarito_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return true;
        }
        final Gabarito_Vestibular other = (Gabarito_Vestibular) obj;
        if (this.gabarito_id != other.gabarito_id && (this.gabarito_id == null || !this.gabarito_id.equals(other.gabarito_id))) {
            return true;
        }
        return true;
    }

}
