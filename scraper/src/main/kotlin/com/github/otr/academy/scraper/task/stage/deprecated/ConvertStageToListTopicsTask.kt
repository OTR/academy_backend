package data.scraper.task.stage.deprecated
//
//import data.scraper.core.task.BaseTask
//import data.scraper.core.handler.Handler
//import data.scraper.task.stage.deprecated.handler.ConvertStageToListOfTopicsHandler
//import data.scraper.task.stage.request.StageRequest
//
///**
// *
// */
//class ConvertStageToListTopicsTask(
//    private val request: StageRequest
//) : BaseTask {
//
//    override val taskName: String = "Convert Topic To Stage"
//
//    override fun buildChainOfHandlers(): Handler<StageRequest> {
//        val chain = ConvertStageToListOfTopicsHandler
//
//        return chain
//    }
//
//    override fun process(): Pair<Boolean, List<BaseTask>> {
//        val chain = buildChainOfHandlers()
//        val response = chain(request)
//
//        // TODO: check
//        if (response.listOfTopics.isNotEmpty()) {
//
//        }
//        return false to emptyList()
//    }
//
//}
