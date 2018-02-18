package com.stevenm.utils

import org.scalatest.selenium.Page

abstract class PageObject(pageUrl: String, pageName: String)(implicit host: String) extends Page {

  override final val url = s"$host/$pageUrl"

  final val title = pageName
}
