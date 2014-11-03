/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vestibular.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.event.FileUploadEvent;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author cleiton
 */
@ManagedBean(name = "mbRetorno")
@ViewScoped
public class MbRetorno implements Serializable {

    public void handleFileUpload(FileUploadEvent event) {

        try {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

            FacesContext aFacesContext = FacesContext.getCurrentInstance();
            ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();

            String realPath = context.getRealPath("/");

            // Aqui cria o diretorio caso não exista
            File file = new File(realPath + "/arquivos/");
            file.mkdirs();

            byte[] arquivo = event.getFile().getContents();
            String caminho = realPath + "/arquivos/" + event.getFile().getFileName();

            // esse trecho grava o arquivo no diretório
            FileOutputStream fos = new FileOutputStream(caminho);
            fos.write(arquivo);
            fos.close();

        } catch (Exception ex) {
            System.out.println("Erro no upload de imagem" + ex);
        }

//        FacesMessage message = new FacesMessage("Sucesso", fileUploadEvent.getFile().getFileName() + " do upload." + fileUploadEvent.getFile().getSize());
//        FacesContext.getCurrentInstance().addMessage(null, message);

    }
}
