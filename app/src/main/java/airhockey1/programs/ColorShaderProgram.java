package airhockey1.programs;

import android.content.Context;

import com.example.pixured_kelvin.firstopenglproject.R;

import static android.opengl.GLES20.glGetAttribLocation;
import static android.opengl.GLES20.glGetUniformLocation;
import static android.opengl.GLES20.glUniform4f;
import static android.opengl.GLES20.glUniformMatrix4fv;

public class ColorShaderProgram extends ShaderProgram {
    // Uniform locations
    private final int uMatrixLocation;

    // Attribute locations
    private final int aPositionLocation;
    private final int uColorLocation;
    public ColorShaderProgram(Context context) {
        super(context, R.raw.vertex_shader,
                R.raw.fragment_shader);
    // Retrieve uniform locations for the shader program.
        uMatrixLocation = glGetUniformLocation(program, U_MATRIX);

    // Retrieve attribute locations for the shader program.
        aPositionLocation = glGetAttribLocation(program, A_POSITION);

        uColorLocation = glGetUniformLocation(program, U_COLOR);

    }

    public void setUniforms(float[] matrix, float r, float g, float b) {
    // Pass the matrix into the shader program.
        glUniformMatrix4fv(uMatrixLocation, 1, false, matrix, 0);
        glUniform4f(uColorLocation, r, g, b, 1f);
    }

    public int getPositionAttributeLocation() {
        return aPositionLocation;
    }


}
