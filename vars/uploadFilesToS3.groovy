def call(String path = "*.jar", String s3Path = "/",String workingDir = "target" ,Map stageParams = [Region: "us-east-1",  s3Bucket: "test-bucket-2221", s3Path: "/"]) {

    withAWS(region: stageParams.Region, credentials:'awscredentials') {
        awsIdentity()
		echo path
		echo s3Path
		echo workingDir
        s3Upload( 
            workingDir: workingDir,
            includePathPattern: path,
            bucket: stageParams.s3Bucket,
            path: s3Path
        )
    }
}