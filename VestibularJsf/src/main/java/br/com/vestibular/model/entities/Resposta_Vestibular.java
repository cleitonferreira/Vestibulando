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
@Table(name = "RESPOSTA_VESTIBULAR")
public class Resposta_Vestibular implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "RESPOSTA_ID", nullable = false)
    private Integer resposta_id;
    @Column(name = "RESPOSTA_FLAG", nullable = true, length = 1)
    private Boolean resposta_flag;
    @Column(name = "RESPOSTA_DATACAD", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resposta_datacad;

    @Column(name = "RESPOSTA_1", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_1;
    @Column(name = "RESPOSTA_2", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_2;
    @Column(name = "RESPOSTA_3", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_3;
    @Column(name = "RESPOSTA_4", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_4;
    @Column(name = "RESPOSTA_5", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_5;
    @Column(name = "RESPOSTA_6", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_6;
    @Column(name = "RESPOSTA_7", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_7;
    @Column(name = "RESPOSTA_8", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_8;
    @Column(name = "RESPOSTA_9", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_9;
    @Column(name = "RESPOSTA_10", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_10;
    @Column(name = "RESPOSTA_12", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_12;
    @Column(name = "RESPOSTA_13", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_13;
    @Column(name = "RESPOSTA_14", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_14;
    @Column(name = "RESPOSTA_15", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_15;
    @Column(name = "RESPOSTA_16", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_16;
    @Column(name = "RESPOSTA_17", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_17;
    @Column(name = "RESPOSTA_18", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_18;
    @Column(name = "RESPOSTA_19", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_19;
    @Column(name = "RESPOSTA_20", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_20;
    @Column(name = "RESPOSTA_21", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_21;
    @Column(name = "RESPOSTA_22", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_22;
    @Column(name = "RESPOSTA_23", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_23;
    @Column(name = "RESPOSTA_24", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_24;
    @Column(name = "RESPOSTA_25", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_25;
    @Column(name = "RESPOSTA_26", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_26;
    @Column(name = "RESPOSTA_27", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_27;
    @Column(name = "RESPOSTA_28", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_28;
    @Column(name = "RESPOSTA_29", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_29;
    @Column(name = "RESPOSTA_30", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_30;
    @Column(name = "RESPOSTA_31", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_31;
    @Column(name = "RESPOSTA_32", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_32;
    @Column(name = "RESPOSTA_33", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_33;
    @Column(name = "RESPOSTA_34", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_34;
    @Column(name = "RESPOSTA_35", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_35;
    @Column(name = "RESPOSTA_36", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_36;
    @Column(name = "RESPOSTA_37", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_37;
    @Column(name = "RESPOSTA_38", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_38;
    @Column(name = "RESPOSTA_39", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_39;
    @Column(name = "RESPOSTA_40", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_40;
    @Column(name = "RESPOSTA_41", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_41;
    @Column(name = "RESPOSTA_42", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_42;
    @Column(name = "RESPOSTA_43", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_43;
    @Column(name = "RESPOSTA_44", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_44;
    @Column(name = "RESPOSTA_45", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_45;
    @Column(name = "RESPOSTA_46", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_46;
    @Column(name = "RESPOSTA_47", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_47;
    @Column(name = "RESPOSTA_48", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_48;
    @Column(name = "RESPOSTA_49", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_49;
    @Column(name = "RESPOSTA_50", nullable = true, columnDefinition = "CHAR(1)")
    private String resposta_50;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_INCRICAO_RESPOSTA")
    @JoinColumn(name = "INSCRICAO_ID", referencedColumnName = "inscricao_id")
    private Inscricao inscricao;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_VESTIBULAR_RESPOSTA")
    @JoinColumn(name = "VESTIBULAR_INFO", referencedColumnName = "vestibular_info")
    private Vestibular vestibular;

    public Resposta_Vestibular() {
        this.inscricao = new Inscricao();
        this.vestibular = new Vestibular();
    }

    public Integer getResposta_id() {
        return resposta_id;
    }

    public void setResposta_id(Integer resposta_id) {
        this.resposta_id = resposta_id;
    }

    public Boolean isResposta_flag() {
        return resposta_flag;
    }

    public void setResposta_flag(Boolean resposta_flag) {
        this.resposta_flag = resposta_flag;
    }

    public Date getResposta_datacad() {
        return resposta_datacad;
    }

    public void setResposta_datacad(Date resposta_datacad) {
        this.resposta_datacad = resposta_datacad;
    }

    public String getResposta_1() {
        return resposta_1;
    }

    public void setResposta_1(String resposta_1) {
        this.resposta_1 = resposta_1;
    }

    public String getResposta_2() {
        return resposta_2;
    }

    public void setResposta_2(String resposta_2) {
        this.resposta_2 = resposta_2;
    }

    public String getResposta_3() {
        return resposta_3;
    }

    public void setResposta_3(String resposta_3) {
        this.resposta_3 = resposta_3;
    }

    public String getResposta_4() {
        return resposta_4;
    }

    public void setResposta_4(String resposta_4) {
        this.resposta_4 = resposta_4;
    }

    public String getResposta_5() {
        return resposta_5;
    }

    public void setResposta_5(String resposta_5) {
        this.resposta_5 = resposta_5;
    }

    public String getResposta_6() {
        return resposta_6;
    }

    public void setResposta_6(String resposta_6) {
        this.resposta_6 = resposta_6;
    }

    public String getResposta_7() {
        return resposta_7;
    }

    public void setResposta_7(String resposta_7) {
        this.resposta_7 = resposta_7;
    }

    public String getResposta_8() {
        return resposta_8;
    }

    public void setResposta_8(String resposta_8) {
        this.resposta_8 = resposta_8;
    }

    public String getResposta_9() {
        return resposta_9;
    }

    public void setResposta_9(String resposta_9) {
        this.resposta_9 = resposta_9;
    }

    public String getResposta_10() {
        return resposta_10;
    }

    public void setResposta_10(String resposta_10) {
        this.resposta_10 = resposta_10;
    }

    public String getResposta_12() {
        return resposta_12;
    }

    public void setResposta_12(String resposta_12) {
        this.resposta_12 = resposta_12;
    }

    public String getResposta_13() {
        return resposta_13;
    }

    public void setResposta_13(String resposta_13) {
        this.resposta_13 = resposta_13;
    }

    public String getResposta_14() {
        return resposta_14;
    }

    public void setResposta_14(String resposta_14) {
        this.resposta_14 = resposta_14;
    }

    public String getResposta_15() {
        return resposta_15;
    }

    public void setResposta_15(String resposta_15) {
        this.resposta_15 = resposta_15;
    }

    public String getResposta_16() {
        return resposta_16;
    }

    public void setResposta_16(String resposta_16) {
        this.resposta_16 = resposta_16;
    }

    public String getResposta_17() {
        return resposta_17;
    }

    public void setResposta_17(String resposta_17) {
        this.resposta_17 = resposta_17;
    }

    public String getResposta_18() {
        return resposta_18;
    }

    public void setResposta_18(String resposta_18) {
        this.resposta_18 = resposta_18;
    }

    public String getResposta_19() {
        return resposta_19;
    }

    public void setResposta_19(String resposta_19) {
        this.resposta_19 = resposta_19;
    }

    public String getResposta_20() {
        return resposta_20;
    }

    public void setResposta_20(String resposta_20) {
        this.resposta_20 = resposta_20;
    }

    public String getResposta_21() {
        return resposta_21;
    }

    public void setResposta_21(String resposta_21) {
        this.resposta_21 = resposta_21;
    }

    public String getResposta_22() {
        return resposta_22;
    }

    public void setResposta_22(String resposta_22) {
        this.resposta_22 = resposta_22;
    }

    public String getResposta_23() {
        return resposta_23;
    }

    public void setResposta_23(String resposta_23) {
        this.resposta_23 = resposta_23;
    }

    public String getResposta_24() {
        return resposta_24;
    }

    public void setResposta_24(String resposta_24) {
        this.resposta_24 = resposta_24;
    }

    public String getResposta_25() {
        return resposta_25;
    }

    public void setResposta_25(String resposta_25) {
        this.resposta_25 = resposta_25;
    }

    public String getResposta_26() {
        return resposta_26;
    }

    public void setResposta_26(String resposta_26) {
        this.resposta_26 = resposta_26;
    }

    public String getResposta_27() {
        return resposta_27;
    }

    public void setResposta_27(String resposta_27) {
        this.resposta_27 = resposta_27;
    }

    public String getResposta_28() {
        return resposta_28;
    }

    public void setResposta_28(String resposta_28) {
        this.resposta_28 = resposta_28;
    }

    public String getResposta_29() {
        return resposta_29;
    }

    public void setResposta_29(String resposta_29) {
        this.resposta_29 = resposta_29;
    }

    public String getResposta_30() {
        return resposta_30;
    }

    public void setResposta_30(String resposta_30) {
        this.resposta_30 = resposta_30;
    }

    public String getResposta_31() {
        return resposta_31;
    }

    public void setResposta_31(String resposta_31) {
        this.resposta_31 = resposta_31;
    }

    public String getResposta_32() {
        return resposta_32;
    }

    public void setResposta_32(String resposta_32) {
        this.resposta_32 = resposta_32;
    }

    public String getResposta_33() {
        return resposta_33;
    }

    public void setResposta_33(String resposta_33) {
        this.resposta_33 = resposta_33;
    }

    public String getResposta_34() {
        return resposta_34;
    }

    public void setResposta_34(String resposta_34) {
        this.resposta_34 = resposta_34;
    }

    public String getResposta_35() {
        return resposta_35;
    }

    public void setResposta_35(String resposta_35) {
        this.resposta_35 = resposta_35;
    }

    public String getResposta_36() {
        return resposta_36;
    }

    public void setResposta_36(String resposta_36) {
        this.resposta_36 = resposta_36;
    }

    public String getResposta_37() {
        return resposta_37;
    }

    public void setResposta_37(String resposta_37) {
        this.resposta_37 = resposta_37;
    }

    public String getResposta_38() {
        return resposta_38;
    }

    public void setResposta_38(String resposta_38) {
        this.resposta_38 = resposta_38;
    }

    public String getResposta_39() {
        return resposta_39;
    }

    public void setResposta_39(String resposta_39) {
        this.resposta_39 = resposta_39;
    }

    public String getResposta_40() {
        return resposta_40;
    }

    public void setResposta_40(String resposta_40) {
        this.resposta_40 = resposta_40;
    }

    public String getResposta_41() {
        return resposta_41;
    }

    public void setResposta_41(String resposta_41) {
        this.resposta_41 = resposta_41;
    }

    public String getResposta_42() {
        return resposta_42;
    }

    public void setResposta_42(String resposta_42) {
        this.resposta_42 = resposta_42;
    }

    public String getResposta_43() {
        return resposta_43;
    }

    public void setResposta_43(String resposta_43) {
        this.resposta_43 = resposta_43;
    }

    public String getResposta_44() {
        return resposta_44;
    }

    public void setResposta_44(String resposta_44) {
        this.resposta_44 = resposta_44;
    }

    public String getResposta_45() {
        return resposta_45;
    }

    public void setResposta_45(String resposta_45) {
        this.resposta_45 = resposta_45;
    }

    public String getResposta_46() {
        return resposta_46;
    }

    public void setResposta_46(String resposta_46) {
        this.resposta_46 = resposta_46;
    }

    public String getResposta_47() {
        return resposta_47;
    }

    public void setResposta_47(String resposta_47) {
        this.resposta_47 = resposta_47;
    }

    public String getResposta_48() {
        return resposta_48;
    }

    public void setResposta_48(String resposta_48) {
        this.resposta_48 = resposta_48;
    }

    public String getResposta_49() {
        return resposta_49;
    }

    public void setResposta_49(String resposta_49) {
        this.resposta_49 = resposta_49;
    }

    public String getResposta_50() {
        return resposta_50;
    }

    public void setResposta_50(String resposta_50) {
        this.resposta_50 = resposta_50;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
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
        hash = 53 * hash + (this.resposta_id != null ? this.resposta_id.hashCode() : 0);
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
        final Resposta_Vestibular other = (Resposta_Vestibular) obj;
        if (this.resposta_id != other.resposta_id && (this.resposta_id == null || !this.resposta_id.equals(other.resposta_id))) {
            return true;
        }
        return true;
    }

}
