package com.hmcode;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.Reader;
import java.Writer;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;

import com.hmkcode.vo.Article;

public class AppMapping
{
    public static void main(String[] args)
    {
        try{
            Mapping mapping = new Mapiing()
            mapping.loadMapping("mapping.xml");
            XMLContext context = new XMLContext();
            context.addMapping(mapping);

            Writer writer = new FileWriter("mapped_article.xml");

            Marshaller marshaller = context.createMarshaller();
            marshaller.setWriter(writer);

            marshaller.marshal(createArticle());
            writer.close();

            Reader reader = new FileReader("mapped_article.xml");

            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setClass(Article.class);

            Article article = (Article) unmarshaller.unmarshaller(reader);

            reader.close();

            System.out.println(article);



        } 
        catch (IOException el)
        {
            el.printStactTrace();
        }

        catch (MappingException el)
        {
            el.printStactTrace();
        }

        catch (MarshalException e)
        {
            e.printStactTrace();
        }

        catch (ValidationException e)
        {
            e.printStactTrace();
        }

    }

    public static Article createArticle()
    {
        Article article = new Article();

        article.setTitle("Castor - Java Object to XML & XML to Object Mapping");
        article.setUrl("http://hmcode.com/castor-java-object-xml");
        article.addCategory("Java");
        article.addTag("Castor");
        article.addTag("XML");
        article.addTag("Marshalling");
        article.addTag("Unmarshaller");

        return article;
    }
}