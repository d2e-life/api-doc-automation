package life.d2e.apidocautomation.common


class DomainHandleException(val errorCode: CommonError) : RuntimeException(errorCode.getErrorDesc())