package hmda.publication.reports.util

import com.github.tototoshi.csv.CSVParser.parse
import hmda.model.ResourceUtils
import hmda.model.publication.reports.ReportTypeEnum
import hmda.publication.reports.util.DispositionType.DispositionType

object ReportsMetaDataLookup extends ResourceUtils {

  private val lines = resourceLines("/reports-metadata.txt")

  val values: Map[String, ReportMetaData] = lines.drop(1).map { line =>
    val data = ReportMetaData.fromString(line)
    data.reportId -> data
  }.toMap

}

case class ReportMetaData(
  reportId: String,
  reportType: ReportTypeEnum,
  reportTable: String,
  dispositions: List[DispositionType],
  description: String
)

case object ReportMetaData {

  def fromString(line: String): ReportMetaData = {
    val values = parse(line, '\\', ',', '"').getOrElse(List())
    val reportId = values.head
    val reportType = ReportTypeEnum.byName(values(1).toLowerCase)
    val reportNumber = values(2)
    val description = values(4)
    val dispositions =
      values(3).split(";").filter(_.nonEmpty).map { d =>
        DispositionType.byName(d.toLowerCase)
      }.toList

    ReportMetaData(
      reportId,
      reportType,
      reportNumber,
      dispositions,
      description
    )
  }
}
