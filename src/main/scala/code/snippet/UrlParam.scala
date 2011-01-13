package code 
package snippet 

import net.liftweb._
import util._
import common.Logger
import common.Full
import sitemap._
import Helpers._
import Loc._

// capture the page parameter information
case class ParamInfo(version: String)

// a snippet that takes the page parameter information
class UrlParam(pi: ParamInfo)  {
  def render = "*" #> pi.version
}

object Param extends Logger{
  // Create a menu for /index/<version>

  val overviewMenu= Menu.param[ParamInfo]("Overview", "Overview" ,                
                                   s => Full(ParamInfo(s)),     
                                   pi => pi.version) / "index" 
  val agentDetailsMenu= Menu.param[ParamInfo]("Agent", "Agent Details" , 
                                   s => Full(ParamInfo(s)), 
                                   pi => pi.version) / "agent-details"
  val serviceManagerDetailsMenu= Menu.param[ParamInfo]("ServiceManager", "Service Manager Details" ,         
                                   s => Full(ParamInfo(s)),     
                                   pi => pi.version) / "servicemanager-details"

  lazy val agentLoc= agentDetailsMenu.toLoc
  lazy val overviewLoc= overviewMenu.toLoc
  lazy val serviceManagerLoc= serviceManagerDetailsMenu.toLoc

  

  def render = "*" #> agentLoc.currentValue.map(_.version)

  def agentVersionString= agentLoc.currentValue.map(_.version)
  def overviewVersionString= overviewLoc.currentValue.map(_.version)
  def serviceManagerVersionString= serviceManagerLoc.currentValue.map(_.version)

}


