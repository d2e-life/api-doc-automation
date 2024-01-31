package life.d2e.apidocautomation.project.command.domain

import life.d2e.apidocautomation.common.CommonError

enum class ProjectError(
    private val errorDesc: String
) : CommonError {
    PROJECT_NOT_FOUND("존재하지 않는 프로젝트"),
    PROJECT_NAME_INVALID("옳지 않은 프로젝트 이름"),
    PROJECT_ENVIRONMENT_EMPTY("프로젝트 환경이 비어있음"),
    ;

    override fun getErrorDesc(): String {
        return this.errorDesc
    }

}