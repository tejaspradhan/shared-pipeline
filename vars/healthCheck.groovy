def ips = []
def vmData = data.vm()
String s = ""
for(int i=0;i<vmData.size();i++)
{

    def ip = vmData[i+1][2]
    final String url = "http://"+"${ip}"+":8090/actuator/health"

    try 
    {         
        def response = bat(script: "@curl -s $url", returnStdout: true)
        JsonSlurper slurper = new JsonSlurper()
        Map parsedJson = slurper.parseText(response)

        String val = parsedJson.status
        if(val!="UP")
        {
            def temp = [:]
            temp.ip = ip
            temp.status = val
            ips.add(temp)  
        }
        s += ip + " : " + val + "^\n\n"

    } 
    catch (Exception e) 
    {
        def temp = [:]
        temp.ip = ip
        temp.status = "DOWN"
        ips.add(temp)
        s += ip + " : " + "DOWN" + "^\n\n"
    }

}

bat "@echo ${s} > logfile.txt"
