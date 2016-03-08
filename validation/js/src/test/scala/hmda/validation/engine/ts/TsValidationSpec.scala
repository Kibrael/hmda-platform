package hmda.validation.engine.ts

import hmda.parser.fi.ts.TsGenerators
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.prop.PropertyChecks
import org.scalatest.{ MustMatchers, PropSpec }

import scala.concurrent.ExecutionContext

//TODO: fails if JSExecutionContext.Implicits.queue is used (runNow is deprecated, but works)
//TODO: fails in Travis CI with org.scalajs.jsenv.ComJSEnv$ComClosedException: JSCom has been closed
//class TsValidationSpec extends PropSpec with PropertyChecks with MustMatchers with TsGenerators with TsValidationEngine with ScalaFutures with CommonTsValidationSpec {
//
//  override implicit val ec: ExecutionContext = scala.scalajs.concurrent.JSExecutionContext.Implicits.runNow

//}

