package data.scraper.task.stage.deprecated
//
//import data.scraper.cache_handler.CheckIfCacheFileExistsAndNotEmpty
//import data.scraper.cache_handler.GetPathToCacheFile
//import data.scraper.cache_handler.ReadSourceFromCache
//import data.scraper.core.task.BaseTask
//import data.scraper.core.handler.Handler
//import data.scraper.task.stage.deprecated.handler.ParseJsonStagesForProjectHandler
//import data.scraper.task.stage.request.StageRequest
//import data.scraper.task.stage.deprecated.request.StageToStepRequestType
//import data.scraper.task.stage.deprecated.request.StagesForProjectRequest
//import data.scraper.task.stage.deprecated.request.StagesForProjectRequestType
//
///**
// *
// */
//@Deprecated("")
//class ParseStagesForProjectTask(
//    private val request: StagesForProjectRequest
//    ) : BaseTask {
//
//    override val taskName: String = "Parse stages for project #${request.id}"
//
//    override fun buildChainOfHandlers(): Handler<StagesForProjectRequest> {
//        val chain = GetPathToCacheFile.setNext(
//            CheckIfCacheFileExistsAndNotEmpty().setNext(
//                ReadSourceFromCache.setNext(
//                    ParseJsonStagesForProjectHandler
//                )
//            )
//        )
//
//        return chain as Handler<StagesForProjectRequest>
//    }
//
//    override fun process(): Pair<Boolean, List<BaseTask>> {
//        val chain = buildChainOfHandlers()
//        val response = chain(request)
//
//        // TODO: Check response
////        if (response.stagesDTO != null && response.stagesDTO.isNotEmpty()) {
////
////            return true to response.stagesDTO.map {
////                LoadStagesForProjectFromRemoteTask(
////                    StagesForProjectRequest(
////                        id = it.id,
////                        type = StagesForProjectRequestType(stageId = it.id, stepId = it.step),
////                        stageDTO = it
////                    )
////                )
////            }
////
////        }
//        return false to emptyList()
//
//    }
//
//}
