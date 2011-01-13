package code
package snippet

import code.model.{Series,Versions}

import scala.xml.{NodeSeq, Text}

import net.liftweb._
import util._
import common.Logger
import mapper.{OrderBy, Descending, SelectableField}
import http.SHtml._
import http.js.JsCmds.{SetHtml, SetValueAndFocus}

import java.util.Date
import Helpers._

class SideBar extends Logger {

  /**
    * Generate the Versions sidebar section
    */

  def terms( xhtml: NodeSeq ): NodeSeq = {
    terms("%", xhtml)
  }

  def terms(prefix: String= "%", xhtml: NodeSeq ) = {
    val version_name_col: List[String]= Versions.getVersionList(prefix)
    //debug(version_name_col)

    def bindConsumption(template: NodeSeq): NodeSeq = {
      version_name_col.flatMap{
        case (ver) => bind("version", template, "number" ->
          link("http://www.google.com/search?aq=f&sourceid=chrome&ie=UTF-8&q=" + ver, () => {}
          , <div>{ver}</div>)
        )
      }
    }
    bind("Versions",xhtml, "list" -> bindConsumption _)
  }
}

