package data.scraper.task.stage.deprecated
//
//import data.scraper.api_handler.LoadSourceJsonHandler
//import data.scraper.cache_handler.CheckIfCacheFileExistsAndNotEmpty
//import data.scraper.cache_handler.GetPathToCacheFile
//import data.scraper.cache_handler.ReadSourceFromCache
//import data.scraper.cache_handler.WriteSourceToCache
//import data.scraper.core.task.BaseTask
//import data.scraper.core.task.BaseTask.Companion.KILOBYTE
//import data.scraper.core.handler.Handler
//import data.scraper.task.stage.deprecated.request.StagesForProjectRequest
//
///**
// *
// */
//@Deprecated("")
//class LoadStabgesForProjectFromRemoteTask(
//    private val request: StagesForProjectRequest
//) : BaseTask {
//
//    override val taskName: String = "Load Stages for project with ID: ${request.id}"
//
//    override fun buildChainOfHandlers(): Handler<StagesForProjectRequest> {
//        val chain = GetPathToCacheFile.setNext(
//            CheckIfCacheFileExistsAndNotEmpty().setNext(
//                ReadSourceFromCache.setNext(
//                    LoadSourceJsonHandler.setNext(
//                        WriteSourceToCache
//                    )
//                )
//            )
//        )
//
//        return chain as Handler<StagesForProjectRequest>
//    }
//
//    override fun process(): Pair<Boolean, List<BaseTask>> {
//        val chain: Handler<StagesForProjectRequest> = buildChainOfHandlers()
//        val response: StagesForProjectRequest = chain(request)
//
//        // TODO: Check response
////        if (
////            response.isCacheExists == true
////            && response.sourceData != null
////        ) {
////            return true to listOf(
////                ParseStagesForProjectTask(
////                    request = response
////                )
////            )
////        }
//        return false to emptyList()
//    }
//
//}
